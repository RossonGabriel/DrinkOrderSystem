package util;

import java.util.Scanner;

//tool for checking data input, output
public class MyToys {
    //The line "---" to decorate the menu
    public static final String LINE = new String(new char[112]).replace('\0', '-');

    private static final Scanner scanner = new Scanner(System.in);

    //return true integer type from user
    public static int getAnInteger(String inputMsg, String errorMsg) {
        int n;
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Integer.parseInt(scanner.nextLine());
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    //return true integer from user in a range
    public static int getAnInteger(String inputMsg, String errorMsg, int lowerBound, int upperBound) {
        int n, tmp;
        //if input lowerBound > upperBound then swap position
        if (lowerBound > upperBound) {
            tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Integer.parseInt(scanner.nextLine());
                if (n < lowerBound || n > upperBound)
                    throw new Exception();
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    //return a true String, not null
    public static String getString(String inputMsg, String errorMsg) {
        String text;
        while (true) {
            System.out.print(inputMsg);
            text = scanner.nextLine().trim();
            if (text.isEmpty())
                System.out.println(errorMsg);
            else
                return text;
        }
    }
}
