package data;

public class VietnameseCoffee extends Beverage{
    public VietnameseCoffee(String id, String name, String description, String size, double price) {
        super(id, name, description, size, price);
    }

    @Override
    public String getBeverageType() {
        return "VIETNAMESE-COFFEE";
    }
}
