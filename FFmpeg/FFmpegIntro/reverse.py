#!/usr/bin/python
import sys, os, glob, re, subprocess

def show_process(args):
    print subprocess.check_output(args)

def main(argv):
    if len(argv) != 2:
        print 'Usage: reverse.py input_file parts_count'
        sys.exit(2)

    input_file = argv[0]
    parts_count = int(argv[1])
    if parts_count <= 0:
        print 'parts_count must be greater than zero'
        sys.exit(2)

    # Get duration
    output = subprocess.check_output([
        "ffprobe",
        "-v", "error",
        "-show_entries", "format=duration",
        "-of", "default=nw=1:nk=1",
        input_file
    ])
    duration = float(output)
    duration_per_part = duration / parts_count

    # Split input video
    print "Split video into segments"
    show_process([
        "ffmpeg", "-y",
        "-v", "error", "-stats",
        "-i", input_file,
        "-c:v", "copy",
        "-an",
        "-f", "segment",
        "-segment_time", str(duration_per_part),
        '-reset_timestamps', "1",
        "tmp_part_i%5d.mp4"
    ])

    # Reverse video parts
    tmp_files = glob.glob('tmp_part_i*.mp4')
    parts_count = len(tmp_files)
    reversed_files = [None] * parts_count
    i = 0
    for filename in tmp_files:
        i += 1
        print "Reverse {}/{}".format(i, parts_count)
        num = int(re.search('tmp_part_i(.+?)\.mp4', filename).group(1))
        result_index = parts_count - num - 1
        reversed_file = "tmp_part_r{}.mp4".format(result_index)
        show_process([
            "ffmpeg", "-y",
            "-v", "error", "-stats",
            "-i", filename,
            "-vf", "reverse",
            reversed_file
        ])
        os.remove(filename)
        reversed_files[result_index] = reversed_file

    # Reverse audio
    print "Reverse audio"
    show_process([
        "ffmpeg", "-y",
        "-v", "error", "-stats",
        "-i", input_file,
        "-af", "areverse",
        "tmp_audio.mp3"
    ])

    # Join video parts and audio
    print "Join {} parts".format(parts_count)
    with open(input_file + '.list', 'w') as listfile:
        for filename in reversed_files:
            listfile.write("file '{}'\n".format(filename))
    show_process([
        "ffmpeg", "-y",
        "-v", "error", "-stats",
        "-f", "concat",
        "-i", input_file + '.list',
        "-i", "tmp_audio.mp3",
        # Uncomment for quick but rough result
        #"-c", "copy",
        input_file + '_rev.mp4'
    ])

    # Clean up
    for filename in glob.glob('tmp_part_r*.mp4'):
        os.remove(filename)
    os.remove('tmp_audio.mp3')
    os.remove(input_file + '.list')


if __name__ == "__main__":
    main(sys.argv[1:])