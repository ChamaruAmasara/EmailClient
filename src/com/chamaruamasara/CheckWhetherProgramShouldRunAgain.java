package com.chamaruamasara;

import java.util.Scanner;

public class CheckWhetherProgramShouldRunAgain implements Execute {


    private static boolean NeedToRunProgramAgain() {
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

    public static boolean execute() {
        return NeedToRunProgramAgain();
    }
}
