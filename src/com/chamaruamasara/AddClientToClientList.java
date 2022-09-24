package com.chamaruamasara;

import java.util.Scanner;

import static com.chamaruamasara.ValidateDate.getDate;
import static com.chamaruamasara.ValidateEmail.ValidateEmail;

public class AddClientToClientList implements Execute {


    // input format - Official: nimal,nimal@gmail.com,ceo
    // Use a single input to get all the details of a recipient
    // code to add a new recipient
    // store details in clientList.txt file
    // Hint: use methods for reading and writing files
    private AddClientToClientList() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Now you are about to save a new recipient");

        //variable to track whether valid input
        boolean validInput = false;

        while (!validInput) {


            //enter recipient name
            System.out.print("Name of the recipient: ");
            String name = scanner.nextLine().trim();

            //enter recipient email
            String email;
            do {
                //enter recipient email
                System.out.print("Email of the recipient: ");
                email = scanner.nextLine().trim();
            } while (!ValidateEmail(email));


            //type of recipient
            System.out.println("""
                    Type of the recipient:\s
                    1 - Official
                    2 - Office Friend
                    3 - Personal""");


            int newRecipientType = 0;

            boolean optionNotSet2 = true;
            while (optionNotSet2) {
                try {
                    newRecipientType = Integer.parseInt(scanner.nextLine().trim());

                    if (newRecipientType >= 1 && newRecipientType <= 3) {
                        optionNotSet2 = false;
                    } else System.out.println("The input is not an option. Enter value within 1-5");

                } catch (Exception e) {
                    System.out.println("Invalid Input!");
                    e.printStackTrace();

                }
            }

            switch (newRecipientType) {
                //official
                case 1 -> {
                    //get designation
                    System.out.print("Designation of the recipient: ");
                    String designation = scanner.nextLine().trim();

                    Official officialContact = new Official(name, email, designation);
                    new WriteToFile(officialContact);
                    validInput = true;
                }

                //office friend
                case 2 -> {
                    //get designation
                    System.out.print("Designation of the recipient: ");
                    String designation = scanner.nextLine().trim();

                    //get birthday
                    String birthday;
                    do {
                        System.out.print("Birthday of the recipient: ");
                        birthday = getDate(scanner.nextLine().trim());
                    }
                    while (birthday.equals(""));

                    OfficeFriend officeFriendContact = new OfficeFriend(name, email, designation, birthday);
                    new WriteToFile(officeFriendContact);
                    validInput = true;
                }
                //personal
                case 3 -> {

                    //get nickname
                    System.out.print("Nick name of the recipient: ");
                    String nickName = scanner.nextLine().trim();

                    //get birthday
                    String birthday;
                    do {

                        System.out.print("Birthday of the recipient: ");
                        birthday = getDate(scanner.nextLine().trim());
                    }
                    while (birthday.equals(""));

                    Personal personalContact = new Personal(name, nickName, email, birthday);
                    new WriteToFile(personalContact);
                    validInput = true;
                }
            }


        }
        System.out.println("Recipient added to clientList.txt");
    }


    public static void execute() {

        new AddClientToClientList();
        return;
    }
}
