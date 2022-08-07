package com.chamaruamasara;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("\nStarting Email Client by Chamaru Amasara - 200390V\n");

        //sending birthday wishes is user prompts
        sendBirthdayWishesToday();

        boolean needToDoAgarin = true;
        while (needToDoAgarin) {
            try {
                int option = getUserOptionMainProgram();


                switch (option) {
                    case 1 -> addClientToClientList();
                    case 2 -> sendEmailViaCMD();
                    case 3 -> printAllBirthdaysOnSpecificDate();
                    case 4 -> listAllEmailsOnSpecificDate();
                    case 5 -> countAllRecipients();
                }
            } catch (Exception e) {
                System.out.println("Invalid Input!");
                e.printStackTrace();
            }

            needToDoAgarin = needToRunProgramAgain();


        }
    }


    //validate Email Addresses
    private static boolean ValidateEmail(String email) {

        //boolean to store whether email address is valid or not
        boolean result = true;

        //try catch to store the
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
            System.out.println("Invalid Email");
        }

        return result;

    }

    // validate dates in birthdays and return date in desired format
    private static String getDate(String date) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            dateFormat.parse(date);
            return date;
        } catch (Exception e) {
            System.out.println("Invalid date! - The date should be in the yyyy/MM/dd format.");
            return "";
        }
    }

    //get current date and time in desired format
    private static String getCurrentDateTime() {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
        return dateFormat.format(date);

    }

    private static void sendBirthdayWishesToday() {

        Scanner scanner = new Scanner(System.in);

        //Send emails for birthdays on today
        System.out.println("Do you want to send emails to people who have birthdays today? yes/no");
        boolean correctReply = false;

        while (!correctReply) {
            String reply = scanner.nextLine().trim();
            if ("yes".equalsIgnoreCase(reply) || "no".equalsIgnoreCase(reply)) {
                correctReply = true;

                if ("yes".equalsIgnoreCase(reply)) {

                    //send birthday wishes


                    // 08/07
                    String newSpecificDateBirthDate = getCurrentDateTime().substring(5, 10).replace("-", "/");

                    //load all data from file
                    File file = new File("clientList.txt");
                    BufferedReader br = null;

                    try {
                        br = new BufferedReader(new FileReader(file));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }

                    // Declaring a string variable
                    String recipientContent;
                    int countBirthDays = 0;
                    try {
                        if (br != null) {
                            while ((recipientContent = br.readLine()) != null)

                                // Print the string
                                if (recipientContent.contains(newSpecificDateBirthDate)) {
                                    countBirthDays++;

                                    String[] recipientType = recipientContent.split(":");
                                    String[] recipientDetails = recipientType[1].split(",");
                                    if (recipientType[0].toLowerCase().contains("office")) {
                                        //send birthday email
                                        Email officeFriendEmail = new Email(recipientDetails[1], "Happy Birthday!", "Wish you a Happy Birthday.\nChamaru", getCurrentDateTime());

                                        new SendMail(officeFriendEmail);
                                    } else if (recipientType[0].toLowerCase().contains("personal")) {
                                        for (String recipientDetail : recipientDetails) {
                                            System.out.println("recipent Details: " + recipientDetail);

                                        }
                                        //send birthday email
                                        Email personalFriendEmail = new Email(recipientDetails[2], "Happy Birthday!", "Hugs and love on your birthday.\nChamaru", getCurrentDateTime());

                                        new SendMail(personalFriendEmail);

                                    }

                                }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    if (countBirthDays == 1)
                        System.out.println("There is 1 birthday today and sent 1 email.");
                    else
                        System.out.println("There are " + countBirthDays + " birthdays today and sent emails to all.");


                }
            } else System.out.println("\nIncorrect reply. You should just enter yes or no");
        }


    }

    private static int getUserOptionMainProgram() {
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

    // input format - Official: nimal,nimal@gmail.com,ceo
    // Use a single input to get all the details of a recipient
    // code to add a new recipient
    // store details in clientList.txt file
    // Hint: use methods for reading and writing files
    private static void addClientToClientList() {

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

    // input format - email, subject, content
    // code to send an email
    private static void sendEmailViaCMD() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Now you are about to Send an email.");

        //enter recipient email
        String email;
        do {
            System.out.print("Enter the email of the recipient: ");
            email = scanner.nextLine().trim();
        } while (!ValidateEmail(email));

        //enter subject
        System.out.print("Enter the Subject of the email: ");
        String subject = scanner.nextLine().trim();

        //content
        System.out.println("Enter the body of the email:");
        String body = scanner.nextLine().trim();

        //send email
        Email emailMessage = new Email(email, subject, body, getCurrentDateTime());

        new SendMail(emailMessage);


        try {
            //create directory to store serialized stuff - else error when write serialize
            new File("emailMessages/").mkdirs();

            //Serialize emailMessage Object
            String fileName = "emailMessages/" + getCurrentDateTime() + ".ser";
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(emailMessage);
            oos.close();
            fos.close();
            System.out.println("Email stored! - Email Object Serialized");
        } catch (Exception e) {
            System.out.println("Email Serialization Error!");
            e.printStackTrace();
        }
    }

    // input format - yyyy/MM/dd (ex: 2018/09/17)
    // code to print recipients who have birthdays on the given date
    private static void printAllBirthdaysOnSpecificDate() {
        System.out.println("Now you are about to print all the recipients who have birthdays on a specific date");
        Scanner scanner = new Scanner(System.in);

        int countBirthDays = 0;

        //get date
        String specificDateBirthDate;
        do {
            System.out.print("Enter specific date: ");
            specificDateBirthDate = getDate(scanner.nextLine().trim());
        }
        while (specificDateBirthDate.equals(""));

        // 2022/08/07
        String newSpecificDateBirthDate = specificDateBirthDate.substring(5);

        try {
            //load all data from file
            File file = new File("clientList.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));

            // Declaring a string variable
            String fileContent;
            // Condition holds true till
            // there is character in a string
            while ((fileContent = br.readLine()) != null)

                // Print the string
                if (fileContent.contains(newSpecificDateBirthDate)) {
                    System.out.println(fileContent);
                    countBirthDays++;
                }
        } catch (Exception e) {
            System.out.println("File handling error!");
            e.printStackTrace();
        }

        if (countBirthDays == 1)
            System.out.println("There is 1 birthday on " + newSpecificDateBirthDate);
        else
            System.out.println("There are " + countBirthDays + " birthdays on " + newSpecificDateBirthDate);
    }

    // input format - yyyy/MM/dd (ex: 2018/09/17)
    // code to print the details of all the emails sent on the input date
    private static void listAllEmailsOnSpecificDate() {
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
                        try {
                            //deserialize objects
                            FileInputStream fis = new FileInputStream("emailMessages/" + listOfFile.getName());
                            ObjectInputStream ois = new ObjectInputStream(fis);
                            Email restoredEmailMessage = (Email) ois.readObject();
                            ois.close();
                            fis.close();
                            //System.out.println("Email Object has been deserialized");
                            System.out.println(
                                    "\nDate Time: " + restoredEmailMessage.dateTime() +
                                            "\nSubject: " + restoredEmailMessage.subject() +
                                            "\nTo: " + restoredEmailMessage.recipientEmail() +
                                            "\nBody: " + restoredEmailMessage.body()
                            );
                        } catch (Exception e) {
                            System.out.println("File read error while deserialization");
                            e.printStackTrace();
                        }
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

    // code to print the number of recipient objects in the application
    private static void countAllRecipients() {

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
        if (recipientCount == 1)
            System.out.println("\nThere is " + recipientCount + " recipient in the application.");
        else
            System.out.println("\nThere are " + recipientCount + " recipients in the application.");


        //print recipient count added in this runtime
        if (Recipient.count == 1)
            System.out.println("Out of them 1 recipient added during this runtime.\n");
        else
            System.out.println("Out of them " + Recipient.count + " recipients added during this runtime.\n");


    }

    private static boolean needToRunProgramAgain() {
        Scanner scanner = new Scanner(System.in);
        boolean needToDoAgarin = true;
        boolean correctReply = false;
        while (!correctReply) {

            System.out.println("\nDo you need to continue the program again? yes/no");

            String reply = scanner.nextLine().trim();
            if ("yes".equalsIgnoreCase(reply) || "no".equalsIgnoreCase(reply)) {
                correctReply = true;
                if ("no".equalsIgnoreCase(reply)) needToDoAgarin = false;
            } else System.out.println("\nIncorrect reply. You should just enter yes or no");

        }
        return needToDoAgarin;
    }
}

