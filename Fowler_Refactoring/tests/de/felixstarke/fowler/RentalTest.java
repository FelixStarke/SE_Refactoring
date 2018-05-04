package de.felixstarke.fowler;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class RentalTest {
    private Movie movie = new Movie("Back To The Future", Movie.REGULAR);
    private Rental rental = new Rental(movie, 10);

    @Test
    void getDaysRented() {
        Assert.assertTrue(rental.getDaysRented() == 10);
    }

    @Test
    void getMovie() {
        Assert.assertEquals(rental.getMovie(), movie);
    }

}