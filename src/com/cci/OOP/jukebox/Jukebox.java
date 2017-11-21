package com.cci.OOP.jukebox;

public class Jukebox {
    Money money;
    Media media;
    Playlist playlist;

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public Playlist getPlaylist() {

        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    void play(Playlist playlist){
        System.out.println("I am playing stuff");

    }



    public static void main(String[] args) {
        Jukebox jukebox = new Jukebox();
        jukebox.setMedia(new CompactDisc());
        jukebox.setMoney(new Coins(1));
        jukebox.setPlaylist(new Playlist(jukebox.getMedia().getSongs()));
        jukebox.play(jukebox.getPlaylist());

    }


}
