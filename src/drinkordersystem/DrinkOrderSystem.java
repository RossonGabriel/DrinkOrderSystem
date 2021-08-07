package drinkordersystem;

import data.CoffeeShop;
import ui.ConsoleMenu;

public class DrinkOrderSystem {

    public static void main(String[] args) {
        //create a console menu
        ConsoleMenu consoleMenu = new ConsoleMenu("Dolphin Cafe");
        consoleMenu.addNewOption("1. View menu");
        consoleMenu.addNewOption("2. View your cart");
        consoleMenu.addNewOption("3. Add beverage to cart");
        consoleMenu.addNewOption("4. Remove beverage from cart");
        consoleMenu.addNewOption("5. Make payment");
        consoleMenu.addNewOption("6. Exit");

        //create a beverage menu for Dolphin Cafe
        CoffeeShop dolphinCafe = new CoffeeShop();
        //Italian Coffee
        dolphinCafe.addNewItalianCoffee("IC001", "ESPRESSO",
                "SIGNATURE COFFEE", "S", 30_000);
        dolphinCafe.addNewItalianCoffee("IC002", "ESPRESSO",
                "SIGNATURE COFFEE", "M", 38_000);
        dolphinCafe.addNewItalianCoffee("IC003", "ESPRESSO MACCHIATO",
                "ESPRESSO, FOAM", "S", 36_000);
        dolphinCafe.addNewItalianCoffee("IC004", "ESPRESSO MACCHIATO",
                "ESPRESSO, FOAM", "M", 42_000);
        dolphinCafe.addNewItalianCoffee("IC005", "AMERICANO",
                "ESPRESSO + HOT WATER", "S", 33_000);
        dolphinCafe.addNewItalianCoffee("IC006", "AMERICANO",
                "ESPRESSO + HOT WATER", "M", 42_000);
        dolphinCafe.addNewItalianCoffee("IC007", "CAPPUCCINO",
                "ESPRESSO, FRESH MILK, FOAM", "S", 38_000);
        dolphinCafe.addNewItalianCoffee("IC008", "CAPPUCCINO",
                "ESPRESSO, FRESH MILK, FOAM", "M", 48_000);
        dolphinCafe.addNewItalianCoffee("IC009", "LATTE",
                "ESPRESSO, FRESH MILK, FOAM", "S", 40_000);
        dolphinCafe.addNewItalianCoffee("IC010", "LATTE",
                "ESPRESSO, FRESH MILK, FOAM", "M", 53_000);
        dolphinCafe.addNewItalianCoffee("IC011", "COFFEE MOCHA",
                "ESPRESSO, CHOCOLATE, FRESH MILK, FOAM", "S", 42_000);
        dolphinCafe.addNewItalianCoffee("IC012", "COFFEE MOCHA",
                "ESPRESSO, CHOCOLATE, FRESH MILK, FOAM", "M", 55_000);
        //Vietnamese Coffee
        dolphinCafe.addNewVietnameseCoffee("VC001", "BLACK COFFEE",
                "100% ROBUSTA COFFEE", "S", 23_000);
        dolphinCafe.addNewVietnameseCoffee("VC002", "BLACK COFFEE",
                "100% ROBUSTA COFFEE", "M", 28_000);
        dolphinCafe.addNewVietnameseCoffee("VC003", "COFFEE MILK",
                "BLACK COFFEE, CONDENSED MILK", "S", 25_000);
        dolphinCafe.addNewVietnameseCoffee("VC004", "COFFEE MILK",
                "BLACK COFFEE, CONDENSED MILK", "M", 33_000);
        dolphinCafe.addNewVietnameseCoffee("VC005", "COFFEE FRESH MILK",
                "BLACK COFFEE, FRESH MILK", "S", 28_000);
        dolphinCafe.addNewVietnameseCoffee("VC006", "COFFEE FRESH MILK",
                "BLACK COFFEE, FRESH MILK", "M", 36_000);

        int choice;
        do {
            consoleMenu.printOption();
            choice = consoleMenu.getChoice();
            switch (choice) {
                case 1:
                    dolphinCafe.printMenuByChoosing();
                    break;
                case 2:
                    dolphinCafe.printCart();
                    break;
                case 3:
                    dolphinCafe.addToCartByID();
                    break;
                case 4:
                    dolphinCafe.removeFromCartByID();
                    break;
                case 5:
                    dolphinCafe.makePayment();
                    break;
                case 6:
                    System.out.println("Bye bye, see you next time!");
                    break;
            }
        } while (choice != 6);
    }
}
