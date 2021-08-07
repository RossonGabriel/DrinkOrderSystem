package data;

public class ItalianCoffee extends Beverage {
    public ItalianCoffee(String id, String name, String description, String size, double price) {
        super(id, name, description, size, price);
    }

    @Override
    public String getBeverageType() {
        return "ITALIAN-COFFEE";
    }
}
