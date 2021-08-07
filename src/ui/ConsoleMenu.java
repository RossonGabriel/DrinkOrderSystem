package ui;

import util.MyToys;

import java.util.ArrayList;

public class ConsoleMenu {
    public String appTitle; //application name ex: Dolphin Cafe
    private final ArrayList<String> optionList = new ArrayList<>(); //options for user to choose

    //constructor
    public ConsoleMenu(String appTitle) {
        this.appTitle = appTitle;
    }

    //add option to the list
    public void addNewOption(String newOption) {
        optionList.add(newOption);
    }

    //print the options that user can choose
    public void printOption() {
        if (optionList.isEmpty()) {
            System.out.println("There is no option to choose!");
            return;
        }
        System.out.println(MyToys.LINE); //print ---------
        System.out.println("Welcome to " + appTitle);
        for (String x : optionList)
            System.out.println(x);
    }

    //return the number of option that user chose
    public int getChoice() {
        int maxOption = optionList.size(); //the total number options in list
        String inputMsg = "Choose [1.." + maxOption + "]: ";
        String errorMsg = "You are required to choose the option 1.." + maxOption;
        int userOption = MyToys.getAnInteger(inputMsg, errorMsg, 1, maxOption);
        return userOption;
    }

}
