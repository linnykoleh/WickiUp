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
    
    