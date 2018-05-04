package de.felixstarke.fowler;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerTest {
    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer("Marty McFly");
    }

    @Test
    void addRental() {
        Movie movie = new Movie("Back To The Future", Movie.REGULAR);
        Rental rental = new Rental(movie, 10);

        customer.addRental(rental);

        StringBuilder expected = new StringBuilder();
        expected.append("Rental Record for " + customer.getName() + "\n");
        expected.append("\tTitle\t\tDays\tAmount\n");
        expected.append("\tBack To The Future\t\t" + rental.getDaysRented() + "\t14.0\n");
        expected.append("Amount owed is 14.0\n");
        expected.append("You earned 1 frequent renter points");

        Assert.assertTrue(customer.statement().compareTo(expected.toString()) == 0);
    }

    @Test
    void getName() {
        Assert.assertTrue(customer.getName().compareTo("Marty McFly") == 0);
    }

    @Test
    void statement() {
        StringBuilder expected = new StringBuilder();
        expected.append("Rental Record for " + customer.getName() + "\n");
        expected.append("\tTitle\t\tDays\tAmount\n");
        expected.append("Amount owed is 0.0\n");
        expected.append("You earned 0 frequent renter points");

        Assert.assertTrue(customer.statement().compareTo(expected.toString()) == 0);
    }

}