package com.costacarol.coreengineering.tema11.model;

public class MusicalGenreRock implements MusicalGenre {

    private boolean isListeningToTheRockPlaylist = false;

    public boolean isListeningToTheRockPlaylist() {
        return isListeningToTheRockPlaylist;
    }

    public void setListeningToTheRockPlaylist(boolean listeningToTheRockPlaylist) {
        isListeningToTheRockPlaylist = listeningToTheRockPlaylist;
    }

    @Override
    public boolean listenPlaylist() {
        setListeningToTheRockPlaylist(true);
        return isListeningToTheRockPlaylist;
    }

    @Override
    public boolean stopListenPlayList() {
        setListeningToTheRockPlaylist(false);
        return isListeningToTheRockPlaylist;
    }
}
