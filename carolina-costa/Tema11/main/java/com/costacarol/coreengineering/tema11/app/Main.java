package com.costacarol.coreengineering.tema11.app;

import com.costacarol.coreengineering.tema11.factory.MusicalGenreFactory;
import com.costacarol.coreengineering.tema11.model.ListOfMusicalGenre;
import com.costacarol.coreengineering.tema11.model.MusicalGenre;

public class Main {

    public static void main(String[] args) {

        MusicalGenre musicalGenre = MusicalGenreFactory.getMusicalGenre(ListOfMusicalGenre.COUNTRY);
        musicalGenre.listenPlaylist();
        musicalGenre.stopListenPlayList();

        MusicalGenre musicalGenre2 = MusicalGenreFactory.getMusicalGenre(ListOfMusicalGenre.POP);
        musicalGenre2.listenPlaylist();
        musicalGenre2.stopListenPlayList();

        MusicalGenre musicalGenre3 = MusicalGenreFactory.getMusicalGenre(ListOfMusicalGenre.ROCK);
        musicalGenre3.listenPlaylist();
        musicalGenre3.stopListenPlayList();
    }
}

