package data;

public abstract class Beverage implements Comparable<Beverage> {
    protected String id;
    protected String name;
    protected String description;
    protected String size;
    protected double price;

    public Beverage(String id, String name, String description, String size, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.size = size;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //Print out beverage information
    public void showInfo() {
        String msg;
        msg = String.format("|%-20s|%5s|%-20s|%-40s|%2s%2s|%,16.0f|\n", getBeverageType(), id, name, description, size, "", price);
        System.out.println(msg);
        //print the beverage info like Exel format
    }

    //Get the type of Beverage
    public abstract String getBeverageType();

    @Override
    public int compareTo(Beverage that) {
        return this.id.compareToIgnoreCase(that.id);
    }
}
