package com.chamaruamasara;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class CountAllRecipients implements Execute {

    // code to print the number of recipient objects in the application
    private CountAllRecipients() {

        int recipientCount = 0;

        try {
            //load all data from file
            File clientFile = new File("clientList.txt");
            BufferedReader br2 = new BufferedReader(new FileReader(clientFile));

            // Declaring a string variable
            String fileContent2;
            // Condition holds true till
            // there is character in a string
            while ((fileContent2 = br2.readLine()) != null)

                if (fileContent2.contains("Official")) {
                    recipientCount++;
                } else if (fileContent2.contains("Office_friend")) {
                    recipientCount++;
                } else if (fileContent2.contains("Personal")) {
                    recipientCount++;
                }
        } catch (Exception e) {
            System.out.println("ClientsList File reading error");
            e.printStackTrace();
        }

        //print recipient count
        if (recipientCount == 0)
            System.out.println("\nThere are no recipients in the application.");
        else if (recipientCount == 1) {
            System.out.println("\nThere is " + recipientCount + " recipient in the application.");
        } else
            System.out.println("\nThere are " + recipientCount + " recipients in the application.");


        //print recipient count added in this runtime
        if (Recipient.count == 0)
            System.out.println("Out of them no recipients added during this runtime.\n");
        else if (Recipient.count == 1)
            System.out.println("Out of them 1 recipient added during this runtime.\n");
        else
            System.out.println("Out of them " + Recipient.count + " recipients added during this runtime.\n");

    }

    public static void execute() {
        new CountAllRecipients();
        return;
    }
}
