package com.linnyk.ffmpeg;

import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.FFmpegExecutor;
import net.bramp.ffmpeg.FFmpegUtils;
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.builder.FFmpegBuilder;
import net.bramp.ffmpeg.probe.FFmpegProbeResult;
import net.bramp.ffmpeg.progress.Progress;
import net.bramp.ffmpeg.progress.ProgressListener;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class FFmpegExample {

    public static void main(String[] args) throws IOException {
        FFmpeg ffmpeg = new FFmpeg("/usr/local/bin/ffmpeg");
        FFprobe ffprobe = new FFprobe("/usr/local/bin/ffprobe");

        FFmpegProbeResult in = ffprobe.probe("/usr/local/bin/5sec.mp4");

        FFmpegBuilder builder = new FFmpegBuilder()

                .setInput(in)     // Filename, or a FFmpegProbeResult
                .overrideOutputFiles(false) // Override the output if it exists

                .addOutput("/usr/local/bin/Video5secondsAfter.mp4")   // Filename for the destination
                .setFormat("mp4")        // Format is inferred from filename, or can be set
                .setTargetSize(250_000)  // Aim for a 250KB file

                .disableSubtitle()       // No subtiles

                .setAudioChannels(1)         // Mono audio
                .setAudioCodec("aac")        // using the aac codec
                .setAudioSampleRate(48_000)  // at 48KHz
                .setAudioBitRate(32768)      // at 32 kbit/s

//                .setVideoCodec("libx264")     // Video using x264
                .setVideoFrameRate(24, 1)     // at 24 frames per second
                .setVideoResolution(640, 480) // at 640x480 resolution

                .setStrict(FFmpegBuilder.Strict.EXPERIMENTAL) // Allow FFmpeg to use experimental specs
                .done();

        FFmpegExecutor executor = new FFmpegExecutor(ffmpeg, ffprobe);

        // Run a one-pass encode
        executor.createJob(builder, new ProgressListener() {

            // Using the FFmpegProbeResult determine the duration of the input
            final double duration_ns = in.getFormat().duration * TimeUnit.SECONDS.toNanos(1);

            @Override
            public void progress(Progress progress) {
                double percentage = progress.out_time_ns / duration_ns;

                // Print out interesting information about the progress
                System.out.println(String.format(
                        "[%.0f%%] status:%s frame:%d time:%s ms fps:%.0f speed:%.2fx",
                        percentage * 100,
                        progress.status,
                        progress.frame,
                        FFmpegUtils.toTimecode(progress.out_time_ns, TimeUnit.NANOSECONDS),
                        progress.fps.doubleValue(),
                        progress.speed
                ));
            }
        }).run();

        // Or run a two-pass encode (which is better quality at the cost of being slower)
//        executor.createTwoPassJob(builder).run();
    }
}
