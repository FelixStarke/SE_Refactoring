package de.felixstarke.fowler;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MovieTest {
    private Movie movie;

    @BeforeEach
    void setUp() {
        movie = new Movie("Back To The Future", Movie.REGULAR);
    }

    @Test
    void getPriceCode() {
        Assert.assertTrue(movie.getPriceCode() == Movie.REGULAR);
    }

    @Test
    void setPriceCode() {
        movie.setPriceCode(Movie.CHILDRENS);
        Assert.assertTrue(movie.getPriceCode() == Movie.CHILDRENS);
    }

    @Test
    void getTitle() {
        Assert.assertTrue(movie.getTitle().compareTo("Back To The Future") == 0);
    }

}