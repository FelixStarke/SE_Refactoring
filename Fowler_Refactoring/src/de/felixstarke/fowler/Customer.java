package de.felixstarke.fowler;

import java.util.*;

class Customer {
    final private String name;
    final private Vector<Rental> rentals = new Vector<>();

    Customer (String name){
        this.name = name;
    }

    void addRental(Rental arg) {
        rentals.addElement(arg);
    }

    String getName (){
        return name;
    }

    String statement() {
        Enumeration _rentals = rentals.elements();
        String result = "Rental Record for " + this.getName() + "\n";
        result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        while (_rentals.hasMoreElements()) {
            Rental each = (Rental) _rentals.nextElement();

            //show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + "\t" + each.getDaysRented() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }

        //add footer lines
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
        return result;
    }

    String htmlStatement() {
        Enumeration _rentals = rentals.elements();
        String result = "<h1>Rentals for <em>" + getName() + "</em></h1><p>\n";

        while(_rentals.hasMoreElements()) {
            Rental each = (Rental) _rentals.nextElement();

            //show figures for this rental
            result += each.getMovie().getTitle() + ": " + String.valueOf(each.getCharge()) + "<br />\n";
        }

        // add footer lines
        result += "</p><p>You owe <em>" + String.valueOf(getTotalCharge()) + "</em></p>\n";
        result += "On this rental you earned <em>" + String.valueOf(getTotalFrequentRenterPoints()) + "</em> frequent renter points</p>";

        return result;
    }

    private double getTotalCharge() {
        double result = 0;
        Enumeration _rentals = rentals.elements();
        while(_rentals.hasMoreElements()) {
            Rental each = (Rental) _rentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration _rentals = rentals.elements();
        while(_rentals.hasMoreElements()) {
            Rental each = (Rental) _rentals.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }
}