package com.costacarol.coreengineering.tema11.model;

public enum ListOfMusicalGenre {
    COUNTRY("country"),
    ROCK("rock"),
    POP("pop");

    private String musicalGenre;

    ListOfMusicalGenre(String musicalGenre){
        this.musicalGenre = musicalGenre;
    }

    public String getMusicalGenre() {
        return musicalGenre;
    }
}
