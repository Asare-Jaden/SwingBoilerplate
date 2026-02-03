package models;

public class Dessert {

    private String name;
    private String dessertType;

    public static final double BASE_PRICE = 4.50;

    public static final String[] AVAILABLE_TOPPINGS = {
        "Sprinkles", "Chocolate Syrup", "Whipped Cream", "Cherry", "Nuts"
    };

    public Dessert(String name, String dessertType) {
        this.name = name;
        this.dessertType = dessertType;
    }

    public String getDescription() {
        return dessertType;
    }

    public double getCost() {
        return BASE_PRICE;
    }

    public String getName() {
        return name;
    }
}
