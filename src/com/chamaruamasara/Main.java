package com.chamaruamasara;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Enter option type:\s
                1 - Adding a new recipient
                2 - Sending an email
                3 - Printing out all the recipients who have birthdays
                4 - Printing out details of all the emails sent
                5 - Printing out the number of recipient objects in the application""");

        int option = Integer.parseInt(scanner.nextLine().trim());

        switch(option){
            case 1:
                // input format - Official: nimal,nimal@gmail.com,ceo
                // Use a single input to get all the details of a recipient
                // code to add a new recipient
                // store details in clientList.txt file
                // Hint: use methods for reading and writing files

                //variable to track whether valid input
                boolean validInput=false;

                while(!validInput) {


                    try {

                        //enter recipient name
                        System.out.print("Name of the recipient: ");
                        String name = scanner.nextLine().trim();

                        //enter recipient email
                        System.out.print("Email of the recipient: ");
                        String email = scanner.nextLine().trim();


                        //type of recipient
                        System.out.println("""
                                    Type of the recipient:\s
                                    1 - Official
                                    2 - Office Friend
                                    3 - Personal""");

                        int newRecipientType = Integer.parseInt(scanner.nextLine().trim());




                        switch (newRecipientType) {
                            //official
                            case 1 -> {
                                //get designation
                                System.out.print("Designation of the recipient: ");
                                String designation=scanner.nextLine().trim();

                                Official officialContact = new Official(name, email, designation);
                                new WriteToFile(officialContact);
                                validInput = true;
                            }

                            //office friend
                            case 2 -> {
                                //get designation
                                System.out.print("Designation of the recipient: ");
                                String designation=scanner.nextLine().trim();

                                //get birthday
                                System.out.print("Birthday of the recipient: ");
                                String birthday=scanner.nextLine().trim();

                                Office_friend officeFriendContact = new Office_friend(name, email, designation, birthday);
                                new WriteToFile(officeFriendContact);
                                validInput = true;
                            }
                            //personal
                            case 3 -> {

                                //get nickname
                                System.out.print("Nick name of the recipient: ");
                                String nickName=scanner.nextLine().trim();

                                //get birthday
                                System.out.print("Birthday of the recipient: ");
                                String birthday=scanner.nextLine().trim();

                                Personal personalContact = new Personal(name, nickName, email, birthday);
                                new WriteToFile(personalContact);
                                validInput = true;
                            }
                        }
                    } catch(Exception e){
                        System.out.println("Invalid Input!");
                    }

                }

            case 2:
                // input format - email, subject, content
                // code to send an email
                break;
            case 3:
                // input format - yyyy/MM/dd (ex: 2018/09/17)
                // code to print recipients who have birthdays on the given date
                break;
            case 4:
                // input format - yyyy/MM/dd (ex: 2018/09/17)
                // code to print the details of all the emails sent on the input date
                break;
            case 5:
                // code to print the number of recipient objects in the application
                break;

        }

        // start email client
        // code to create objects for each recipient in clientList.txt
        // use necessary variables, methods and classes
    }
}