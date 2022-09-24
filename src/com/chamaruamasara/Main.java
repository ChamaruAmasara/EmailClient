package com.chamaruamasara;

import static com.chamaruamasara.GetUserOptionMainProgram.getUserOptionMainProgram;

public class Main {
    public static void main(String[] args) {

        System.out.println("\nStarting Email Client by Chamaru Amasara - 200390V\n");

        //sending birthday wishes is user prompts
        SendBirthdayWishesStart.execute();

        boolean needToDoAgarin = true;
        while (needToDoAgarin) {
            try {
                int option = getUserOptionMainProgram();


                switch (option) {
                    //singleton design pattern for each option
                    case 1 -> AddClientToClientList.execute();
                    case 2 -> SendEmailViaCMD.execute();
                    case 3 -> PrintAllBirthdaysOnSpecificDate.execute();
                    case 4 -> ListAllEmailsOnSpecificDate.execute();
                    case 5 -> CountAllRecipients.execute();
                }
            } catch (Exception e) {
                System.out.println("Invalid Input!");
                e.printStackTrace();
            }

            needToDoAgarin = CheckWhetherProgramShouldRunAgain.execute();


        }
    }


}

