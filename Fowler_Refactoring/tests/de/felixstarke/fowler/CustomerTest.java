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
    void addRental1() {
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
    void addRental2() {
        Movie movie1 = new Movie("Back To The Future", Movie.REGULAR);
        Movie movie2 = new Movie("Back To The Future III", Movie.NEW_RELEASE);
        Rental rental1 = new Rental(movie1, 10);
        Rental rental2 = new Rental(movie2, 5);

        customer.addRental(rental1);
        customer.addRental(rental2);

        StringBuilder expected = new StringBuilder();
        expected.append("Rental Record for " + customer.getName() + "\n");
        expected.append("\tTitle\t\tDays\tAmount\n");
        expected.append("\tBack To The Future\t\t" + rental1.getDaysRented() + "\t14.0\n");
        expected.append("\tBack To The Future III\t\t" + rental2.getDaysRented() + "\t15.0\n");
        expected.append("Amount owed is 29.0\n");
        expected.append("You earned 3 frequent renter points");

        Assert.assertTrue(customer.statement().compareTo(expected.toString()) == 0);
    }

    @Test
    void addRental3() {
        Movie movie1 = new Movie("Back To The Future", Movie.REGULAR);
        Movie movie2 = new Movie("Back To The Future II", Movie.CHILDRENS);
        Movie movie3 = new Movie("Back To The Future III", Movie.NEW_RELEASE);
        Rental rental1 = new Rental(movie1, 10);
        Rental rental2 = new Rental(movie2, 5);
        Rental rental3 = new Rental(movie3, 4);

        customer.addRental(rental1);
        customer.addRental(rental2);
        customer.addRental(rental3);

        StringBuilder expected = new StringBuilder();
        expected.append("Rental Record for " + customer.getName() + "\n");
        expected.append("\tTitle\t\tDays\tAmount\n");
        expected.append("\tBack To The Future\t\t" + rental1.getDaysRented() + "\t14.0\n");
        expected.append("\tBack To The Future II\t\t" + rental2.getDaysRented() + "\t4.5\n");
        expected.append("\tBack To The Future III\t\t" + rental3.getDaysRented() + "\t12.0\n");
        expected.append("Amount owed is 30.5\n");
        expected.append("You earned 4 frequent renter points");

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