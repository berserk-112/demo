package com.example.patter.adapterPatter;

public class AdapterPatterDemo {
    public static void main(String[] args){
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3", "music");
        audioPlayer.play("mp4", "music");
        audioPlayer.play("vlc", "music");
        audioPlayer.play("tlc", "music");
    }
}
