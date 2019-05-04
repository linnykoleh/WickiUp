## FFmpeg

### Main commands for converting formats 

- `ffmpeg -i 5sec.flv sample.mp4`
    - 5sec.mp4 - input video
    - sample.mp4 - output video
    
- `ffmpeg -i 5sec.mp4 sample.mp3`
    - 5sec.mp4 - input video
    - sample.mp4 - output audio   
    
- `ffmpeg -i 5sec.flac sample.mp3`
    - 5sec.mp4 - input audio
    - sample.mp4 - output audio       
    
- `ffmpeg -i 5sec.flac sample.gif`
  - 5sec.mp4 - input audio
  - sample.mp4 - output gif
  
### Updating video parameters

- Delete audio 
    - `ffmpeg -i 5sec.mp4 -an video-no-audio.mp4`        
        - **-an** - delete audio

- Update bitrate
    - `ffmpeg -i 5sec.mp4 -b:v 200k video-bitrate-new.mp4`    
        - **-b:v 200k** - create new bitrate for video
        - **-b:a 200k** - create new bitrate for audio
        
- Update frame rate(fps)
    - `ffmpeg -i 5sec.mp4 -r 10 5sec-10-fps.mp4` 
        - **-r 10** - rate 10  

- Update resolution
    - `ffmpeg -i 5sec.mp4 -s 640x480 5sec-640-480.mp4`
        - **-s 640x480** - create new resolution

### Cut video by time

- `ffmpeg -i 5sec.mp4 -t 3 video-3-sec.mp4`
    - **-t {number in seconds}** 
    
- `ffmpeg -ss 5 -i 5sec.mp4 -t 3 video-3-sec.mp4`    
    - **-ss {number in seconds}** - skip first {number in seconds}
    
- `ffmpeg -ss 00:00:05 -i 5sec.mp4 -t 3.5 video-3-sec.mp4`
    - **-ss 00:00:05** - time in format __hh:mm:ss__
    
- `ffmpeg -sseof -5 -i 5sec.mp4 video-last-5-sec.mp4`
    - **-sseof -{number is seconds}** - cut last {number is seconds}
    
### Cut video (cropping)    

- `ffmpeg -i 5sec.mp4 -vf crop=100:50:0:0 cropp-video.mp4`
    - **-vf** - filters
    - **crop={width}:{height}:{верхняя левая точка изображения{x:y}}** - coordinates

- `ffmpeg -i 5sec.mp4 -vf crop=100:50:in_w-200:in_h-300 cropp-video.mp4`    
    - **in_w** - constant, the width of the video
    - **in_h** - constant, the height of the video
    
- `ffmpeg -i 5sec.mp4 -vf crop=100:50:in_w/2-200:in_h/2-300 cropp-video.mp4`    
    - **in_w/2** - выражение, чтобы поделить ширина на 2
    - **in_h/2** - выражение, чтобы поделить высоту на 2    
    
### Acceleration and deceleration 

- `ffmpeg -i 5sec.mp4 -vf setpts=0.5*PTS video-small-speed.mp4`   
    - **-vf** - filters
    - **setpts** - presentation timeline
        - **<1xPTS** - acceleration
        - **>1xPTS** - deceleration
       
### Rotate

- `ffmpeg -i 5sec.mp4 -vf transpose=0 transpose-video.mp4`        
     - **-vf** - filters
     - **transpose** - transpose video
        - **0** - поворачивает против часовой на 90 градусов и отражает видео
        - **1** - поворачивает по часовой на 90 градусов 
        - **2** - поворачивает против часовой на 90 градусов 
        - **3** - поворачивает по часовой на 90 градусов и отражает видео 
        
- `ffmpeg -i 5sec.mp4 -vf rotate=135*PI/180 rotate-video.mp4`  
    - **-vf** - filters
    - **rotate={выражение в радианах}**  
    
- `ffmpeg -i 5sec.mp4 -vf hflip flip-video.mp4`  
    - **-vf** - filters
    - **hflip, vflip** - по горизонтали или по вертикали 
    
### Subtitles

- `ffmpeg -i 5sec.mp4 -vf subtitles=file-subtitles.srt result-with-subtitles.mp4`    
    - **subtitles={file with subtitles}**
    
- `ffmpeg -i 5sec.mp4 -vf subtitles=file-subtitles.acc result-with-subtitles.mp4`    
    - **subtitles={file with subtitles}**    
    
### Logo

- `ffmpeg -i 5sec.mp4 -i logo.jpg -filter_complex "[0:v][1:v]overlay=10:10" result-logo.mp4`
    - **-i logo.jpg** - logo file
    - **-filter_complex** - filter
    - **"[0:v][1:v]overlay=10:10"** - [нулевой поток:взять только видео][первый поток:взять только видео]overlay=координаты
    
- `ffmpeg -i 5sec.mp4 -i logo.jpg -filter_complex "[0:v][1:v]overlay=main_w-overlay_w-20:main_h-overlay_h-10" result-logo.mp4`
    - **main_w** - ширина видео
    - **overlay_w** - ширина лого
    - **main_h** - высота видео
    - **overlay_h** - высота лого
    
### Stable video

- `ffmpeg -i 5sec.mp4 -vf deshake=edge=0 stable-video.mp4`
    - **deshake=edge=0** - очищает все что за краями изображения
    - **deshake=edge=1** - накладывает оригинальное видео под стабилизированное
    - **deshake=edge=2** - расширяет края
    - **deshake=edge=3** - отзеркаливание
    
### FFplay

- video and audio player

### FFprobe

- Shows basic info about file
    - `ffprobe -i 5sec.mp4 -show_format`

- Shows info about audio and video streams   
    - `ffprobe -i 5sec.mp4 -show_streams`  
    - `ffprobe -i 5sec.mp4 -show_streams -print_format xml` 
        - **print_format** - print in formats 
            - xml
            - json
            - csv
            - ...
    - `ffprobe -v quiet -show_entries format=duration -of default=noprint_wrappers=1 5sec.mp4`
    
### Reverse

- In order to create reverse of the video FFmpeg download the video to RAM.
It's ok for small videos, for big videos need to cut videos and process them partially
  

- `ffmpeg -i 5sec.mp4 -vf reverse -af areverse reverse.video.mp4`
    - **-vf** - video filters
    - **reverse** - reverse for video
    - **-af** - audio filters
    - **areverse** - audio reverse           