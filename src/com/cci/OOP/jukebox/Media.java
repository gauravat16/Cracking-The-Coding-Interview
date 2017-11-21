package com.cci.OOP.jukebox;

import java.util.ArrayList;

public class Media {

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }

    ArrayList<Song> songs;
}
