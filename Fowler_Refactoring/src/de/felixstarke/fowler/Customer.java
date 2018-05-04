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
        int frequentRenterPoints = 0;
        Enumeration enum_rentals = rentals.elements();	    
        String result = "Rental Record for " + this.getName() + "\n";
        result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        while (enum_rentals.hasMoreElements()) {
            Rental each = (Rental) enum_rentals.nextElement();

            // add frequent renter points
            frequentRenterPoints += each.getFrequentRenterPoints();

            //show figures for this rental
            result += "\t" + each.getMovie().getTitle()+ "\t" + "\t" + each.getDaysRented() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }
        //add footer lines
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
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
}