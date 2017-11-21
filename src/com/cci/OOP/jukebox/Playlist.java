package com.cci.OOP.jukebox;

import java.util.ArrayList;

public class Playlist {
    ArrayList<Song> songList;

    Playlist(ArrayList<Song> songList){
        this.songList=songList;
    }

    public ArrayList<Song> getSongList() {
        return songList;
    }

    public void setSongList(ArrayList<Song> songList) {
        this.songList = songList;
    }

    Playlist generatePlaylist(){
        return new Playlist(getSongList());
    }
}
