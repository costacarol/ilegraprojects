package com.costacarol.coreengineering.tema11.factory;

import com.costacarol.coreengineering.tema11.model.*;
import org.junit.Assert;
import org.junit.Test;

public class MusicalGenreFactoryTest {

    @Test
    public void testGetMusicalGenreCountry() {
        MusicalGenre musicalGenre = MusicalGenreFactory.getMusicalGenre(ListOfMusicalGenre.COUNTRY);
        Assert.assertTrue(musicalGenre instanceof MusicalGenreCountry);
    }

    @Test
    public void testGetMusicalGenrePop() {
        MusicalGenre musicalGenre = MusicalGenreFactory.getMusicalGenre(ListOfMusicalGenre.POP);
        Assert.assertTrue(musicalGenre instanceof MusicalGenrePop);
    }

    @Test
    public void testGetMusicalGenreRock() {
        MusicalGenre musicalGenre = MusicalGenreFactory.getMusicalGenre(ListOfMusicalGenre.ROCK);
        Assert.assertTrue(musicalGenre instanceof MusicalGenreRock);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testGetMusicalGenreNull() {
        MusicalGenre musicalGenre = MusicalGenreFactory.getMusicalGenre(null);
    }

}