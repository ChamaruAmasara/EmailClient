package com.chamaruamasara;

import java.io.*;
import java.util.Scanner;

public class SendBirthdayWishesStart {


    private SendBirthdayWishesStart() {

        Scanner scanner = new Scanner(System.in);
        try {
            //Checking whether the clientList file exists

            File fileTest = new File("clientList.txt");
            BufferedReader br = null;
            new BufferedReader(new FileReader(fileTest));


            //Send emails for birthdays on today
            System.out.println("Do you want to send emails to people who have birthdays today? yes/no");
            boolean correctReply = false;

            while (!correctReply) {
                String reply = scanner.nextLine().trim();
                if ("yes".equalsIgnoreCase(reply) || "no".equalsIgnoreCase(reply)) {
                    correctReply = true;

                    if ("yes".equalsIgnoreCase(reply)) {


                    }
                } else System.out.println("\nIncorrect reply. You should just enter yes or no");
            }
        } catch (FileNotFoundException e) {
            //if clientList is not found
            System.out.println("You haven't add any recipients yet to send Birthday wishes. You can send Birthday Wishes to your friends after adding them via this application and we'll send emails on their birthdays.");
        }


    }

    public static void execute() {

        new SendBirthdayWishesStart();
    }
}