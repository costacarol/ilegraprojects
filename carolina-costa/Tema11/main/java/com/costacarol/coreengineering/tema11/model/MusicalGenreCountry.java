package com.costacarol.coreengineering.tema11.model;

public class MusicalGenreCountry implements MusicalGenre{

    private boolean isListeningToTheCountryPlaylist = false;

    private boolean isListeningToTheCountryPlaylist() {
        return isListeningToTheCountryPlaylist;
    }

    public void setListeningToTheCountryPlaylist(boolean listeningToTheCountryPlaylist) {
        isListeningToTheCountryPlaylist = listeningToTheCountryPlaylist;
    }

    @Override
    public boolean listenPlaylist() {
        setListeningToTheCountryPlaylist(true);
        return isListeningToTheCountryPlaylist;
    }

    @Override
    public boolean stopListenPlayList() {
        setListeningToTheCountryPlaylist(false);
        return isListeningToTheCountryPlaylist;
    }
}
