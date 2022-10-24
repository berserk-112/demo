package com.example.patter.adapterPatter;

public class VlcPlayer implements AdvancedMediaPlayer{
    @Override
    public void playVlc(String filename) {
        System.out.println("Playing vlc file name: " + filename);
    }

    @Override
    public void playMp4(String filename) {

    }
}
