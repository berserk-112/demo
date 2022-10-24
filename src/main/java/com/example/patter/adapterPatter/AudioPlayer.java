package com.example.patter.adapterPatter;

public class AudioPlayer implements MediaPlayer{
    AdapterPlayer adapterPlayer;
    @Override
    public void play(String audioType, String filename) {
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("playing mp3 file name: " + filename);
        } else if (audioType.equalsIgnoreCase("mp4")
                || audioType.equalsIgnoreCase("vlc")) {
            adapterPlayer = new AdapterPlayer(audioType);
            adapterPlayer.play(audioType, filename);
        } else {
            System.out.println("Invalid Type");
        }
    }
}
