package data;

import util.MyToys;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CoffeeShop {
    private final ArrayList<Beverage> menu = new ArrayList();
    private final ArrayList<Beverage> cart = new ArrayList();

    public void addNewItalianCoffee(String id, String name, String description, String size, double price) {
        menu.add(new ItalianCoffee(id, name, description, size, price));
    }

    public void addNewVietnameseCoffee(String id, String name, String description, String size, double price) {
        menu.add(new VietnameseCoffee(id, name, description, size, price));
    }

    public void printMenuByChoosing() {
        //Ask user how they want to view
        System.out.println("1. View menu by default");
        System.out.println("2. View menu ascending by beverage name");
        System.out.println("3. View menu ascending by beverage price");
        int choice = MyToys.getAnInteger("Choose [1..3]: ", "You are required to choose the option 1..3", 1, 3);
        //switch between 3 options
        switch (choice) {
            case 1:
                printMenuAscendingByID();
                break;
            case 2:
                printMenuAscendingByName();
                break;
            case 3:
                printMenuAscendingByPrice();
                break;
        }
    }

    private void printMenu() {
        if (menu.isEmpty()) {
            System.out.println("The menu is empty now. Please come back later!!");
            return;
        }
        //print title
        System.out.println(MyToys.LINE); //print -------------------------
        System.out.printf("%58s", "MENU\n"); //print "MENU" in the center of line
        System.out.println(MyToys.LINE); //print -------------------------
        //print header
        String header = String.format("|%12s%8s|%4s%1s|%12s%8s|%26s%14s|%4s|%11s%5s|",
                "TYPE", "", "ID", "", "NAME", "", "DESCRIPTION", "", "SIZE", "PRICE", "");
        System.out.println(header);
        System.out.println(MyToys.LINE); //print -------------------------
        //print beverage
        for (Beverage x : menu)
            x.showInfo();
    }

    private void printMenuAscendingByID() {
        //Sorting Beverage ID by using Comparable
        //By implementing Comparable interface in Beverage class and @Override compareTo() method
        Collections.sort(menu);
        printMenu();
    }

    private void printMenuAscendingByName() {
        //Sorting Beverage name by using Comparator, Anonymous class
        Comparator<Beverage> nameBalance = new Comparator<Beverage>() {
            @Override
            public int compare(Beverage o1, Beverage o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        };
        Collections.sort(menu, nameBalance);
        printMenu();
    }

    private void printMenuAscendingByPrice() {
        //Sorting Beverage price by using 2 for loops
        for (int i = 0; i < menu.size() - 1; i++)
            for (int j = i + 1; j < menu.size(); j++)
                if (menu.get(i).getPrice() > menu.get(j).getPrice()) {
                    Beverage tmp = menu.get(i);
                    menu.set(i, menu.get(j));
                    menu.set(j, tmp);
                }
        printMenu();
    }

    private Beverage getBeverageFromMenuByID (String id) {
        for (Beverage x : menu)
            if (id.equalsIgnoreCase(x.getId()))
                return x;
        return null;
    }

    private String getIDFromUser() {
        String inputMsg = "Input beverage ID: ";
        String errorMsg = "You are required to input ID!";
        //Ask for ID from user and return
        return MyToys.getString(inputMsg, errorMsg);
    }

    public void printCart() {
        //print title
        System.out.println(MyToys.LINE); //print --------------------
        System.out.printf("%61s", "YOUR CART\n"); //print "YOUR CART" in the center of line
        System.out.println(MyToys.LINE); //print --------------------
        //print header
        String header = String.format("|%12s%8s|%4s%1s|%12s%8s|%26s%14s|%4s|%3s|%9s%4s|",
                "TYPE", "", "ID", "", "NAME", "", "DESCRIPTION", "", "SIZE", "NUM", "PRICE", "");
        System.out.println(header);
        //if cart has beverage then print it all
        if (!cart.isEmpty())
            for (Beverage x : cart) {
                String outputMsg;
                outputMsg = String.format("|%-20s|%5s|%-20s|%-40s|%2s%2s|%3d|%,13.0f|\n", x.getBeverageType(), x.getId(),
                        x.getName(), x.getDescription(), x.getSize(), "", 1, x.getPrice());
                System.out.println(outputMsg);
            }
        //print total money
        System.out.printf("%15s%,95.0f\n", "TOTAL PAYMENT", totalPayment());
    }

    public void addToCartByID() {
        String id = getIDFromUser();
        //Using id to scan in menu
        Beverage beverageByID = getBeverageFromMenuByID(id);
        if (beverageByID == null)
            System.out.println("ID not found!!!");
        else {
            cart.add(beverageByID);
            System.out.println("Add to cart successfully!");
            printCart();
        }
    }

    public void removeFromCartByID() {
        String id = getIDFromUser();
        //Using id to scan in cart
        for (Beverage x : cart) {
            if (id.equalsIgnoreCase(x.getId())) {
                cart.remove(x);
                printCart();
                return;
            }
        }
        System.out.println("ID not found!!!");
    }

    public void makePayment() {
        System.out.printf("Your total payment is %,.0f VND\n", totalPayment());
        System.out.println("The payment was successfully made!");
        cart.clear();
    }

    private double totalPayment() {
        double payment = 0;
        for (Beverage x : cart) {
            payment += x.getPrice();
        }
        return payment;
    }
}
