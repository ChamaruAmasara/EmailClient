package com.chamaruamasara;

import java.io.File;
import java.util.Scanner;

import static com.chamaruamasara.ValidateDate.getDate;

public class ListAllEmailsOnSpecificDate implements Execute {

    // input format - yyyy/MM/dd (ex: 2018/09/17)
    // code to print the details of all the emails sent on the input date
    private ListAllEmailsOnSpecificDate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Now you are about to print out details of all the emails sent on a specific date");

        //get date
        String specificDateEmails;
        do {
            System.out.print("Enter specific date: ");
            specificDateEmails = getDate(scanner.nextLine().trim());
        }
        while (specificDateEmails.equals(""));

        //converting date into the specific format
        String newSpecificDateEmails = specificDateEmails.replace("/", "-");


        //get all files in the folder
        File folder = new File("emailMessages/");
        File[] listOfFiles = folder.listFiles();

        //count number of emails
        int emailCount = 0;

        if (listOfFiles != null) {
            for (File listOfFile : listOfFiles) {
                if (listOfFile.isFile()) {


                    if (listOfFile.getName().contains(newSpecificDateEmails)) {
                        //Deserialze the object
                        new DeserializeEmail("emailMessages/" + listOfFile.getName());
                        emailCount++;
                    }
                } else if (listOfFile.isDirectory()) {
                    System.out.println("Directory " + listOfFile.getName());
                }
            }
        }
        if (emailCount == 1)
            System.out.println("\nThere was " + emailCount + " email on " + newSpecificDateEmails + ".");
        else
            System.out.println("\nThere were " + emailCount + " emails on " + newSpecificDateEmails + ".");

    }

    public static void execute() {

        new ListAllEmailsOnSpecificDate();
        return;
    }
}
