package de.felixstarke.fowler;

class Movie {
    static final int CHILDREN = 2;
    static final int REGULAR = 0;
    static final int NEW_RELEASE = 1;

    final private String title;
    private int priceCode;

    Movie(String title, int priceCode) {
        this.title = title;
        setPriceCode(priceCode);
    }

    int getPriceCode() {
        return priceCode;
    }

    void setPriceCode(int arg) {
        priceCode = arg;
    }

    String getTitle() {
        return title;
    }

    double getCharge(int daysRented) {
        double result = 0;
        switch (getPriceCode()) {
            case Movie.REGULAR:
                result += 2;
                if (daysRented > 2)
                    result += (daysRented - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                result += daysRented * 3;
                break;
            case Movie.CHILDREN:
                result += 1.5;
                if (daysRented > 3)
                    result += (daysRented - 3) * 1.5;
                break;
            default:
                break;
        }
        return result;
    }

    int getFrequentRenterPoints(int daysRented) {
        if (getPriceCode() == Movie.NEW_RELEASE && daysRented > 1)
            return 2;
        return 1;
    }
}