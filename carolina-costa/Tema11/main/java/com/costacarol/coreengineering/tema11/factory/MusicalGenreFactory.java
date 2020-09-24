package com.costacarol.coreengineering.tema11.factory;

import com.costacarol.coreengineering.tema11.model.*;

public class MusicalGenreFactory {

    public static MusicalGenre getMusicalGenre(ListOfMusicalGenre musicalGenreOptions) {
        if(musicalGenreOptions == null){
            throw new IllegalArgumentException("Parâmetro inválido: insira um gênero musical disponível. ");
        }
        switch (musicalGenreOptions){
            case COUNTRY:
                return new MusicalGenreCountry();
            case ROCK:
                return new MusicalGenreRock();
            case POP:
                return new MusicalGenrePop();
            default:
                throw new IllegalArgumentException("Parâmetro inválido: escolha uma entre as opções disponíveis.");
        }
    }
}
