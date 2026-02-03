package models;

import java.util.ArrayList;

public class Drink {

    public static final String[] AVAILABLE_DRINKS = {
        "Soda", "Water", "Lemonade", "Iced Tea"
    };

    public static final String[] SIZES = {
        "Small", "Medium", "Large"
    };

    private static final double SMALL_PRICE = 1.49;
    private static final double MEDIUM_PRICE = 1.99;
    private static final double LARGE_PRICE = 2.49;

    private String drinkType;
    private String size;

    public Drink() {
        drinkType = "";
        size = "Small"; // default
    }

    public void setDrinkType(String drinkType) {
        this.drinkType = drinkType;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        switch (size) {
            case "Medium": return MEDIUM_PRICE;
            case "Large": return LARGE_PRICE;
            default: return SMALL_PRICE;
        }
    }

    public double getTax(double price) {
        return price * 0.08;
    }

    public double getPriceWithTax() {
        double price = getPrice();
        return price + getTax(price);
    }

    @Override
    public String toString() {
        return size + " " + drinkType;
    }
}
