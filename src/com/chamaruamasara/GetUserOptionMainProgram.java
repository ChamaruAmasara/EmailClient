package com.chamaruamasara;

import java.util.Scanner;

public class GetUserOptionMainProgram {

    public static int getUserOptionMainProgram() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                                        
                Enter option type:\s
                1 - Adding a new recipient
                2 - Sending an email
                3 - Printing out all the recipients who have birthdays
                4 - Printing out details of all the emails sent
                5 - Printing out the number of recipient objects in the application""");

        int option = 0;

        boolean optionNotSet = true;
        while (optionNotSet) {
            try {
                option = Integer.parseInt(scanner.nextLine().trim());

                if (option >= 1 && option <= 5) {
                    optionNotSet = false;
                } else System.out.println("The input is not an option. Enter value within 1-5");

            } catch (Exception e) {
                System.out.println("Invalid Input!");
                e.printStackTrace();

            }
        }
        return option;
    }
}
