package com.chamaruamasara;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

import static com.chamaruamasara.ValidateDate.getDate;

public class PrintAllBirthdaysOnSpecificDate implements Execute {


    // input format - yyyy/MM/dd (ex: 2018/09/17)
    // code to print recipients who have birthdays on the given date
    private PrintAllBirthdaysOnSpecificDate() {
        System.out.println("Now you are about to print all the recipients who have birthdays on a specific date");
        Scanner scanner = new Scanner(System.in);

        int countBirthDays = 0;

        //get date
        String specificDateBirthDate;
        do {
            System.out.print("Enter specific date in yyyy/MM/dd: ");
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
        else if (countBirthDays == 0) {
            System.out.println("There are no any birthdays today.");

        } else
            System.out.println("There are " + countBirthDays + " birthdays on " + newSpecificDateBirthDate);
    }

    public static void execute() {

        new PrintAllBirthdaysOnSpecificDate();
        return;
    }
}
