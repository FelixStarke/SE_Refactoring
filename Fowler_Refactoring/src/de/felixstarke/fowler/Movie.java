package de.felixstarke.fowler;

class Movie {
    static final int CHILDREN = 2;
    static final int REGULAR = 0;
    static final int NEW_RELEASE = 1;

    final private String title;
    private Price price;

    Movie(String title, int price) {
        this.title = title;
        setPriceCode(price);
    }

    int getPriceCode() {
        return price.getPriceCode();
    }

    void setPriceCode(int arg) {
        switch(arg) {
            case Movie.REGULAR:
                price = new RegularPrice();
                break;
            case Movie.CHILDREN:
                price = new ChildrensPrice();
                break;
            case Movie.NEW_RELEASE:
                price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        }
    }

    String getTitle() {
        return title;
    }

    double getCharge(int daysRented) {
        return price.getCharge(daysRented);
    }

    int getFrequentRenterPoints(int daysRented) {
        if (getPriceCode() == Movie.NEW_RELEASE && daysRented > 1)
            return 2;
        return 1;
    }
}