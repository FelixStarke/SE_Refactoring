package de.felixstarke.fowler;

abstract class Price {
    abstract int getPriceCode();
    abstract double getCharge(int daysRented);
}
