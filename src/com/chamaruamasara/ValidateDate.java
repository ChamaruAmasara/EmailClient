package com.chamaruamasara;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ValidateDate {

    // validate dates in birthdays and return date in desired format
    public static String getDate(String date) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            dateFormat.parse(date);
            return date;
        } catch (Exception e) {
            System.out.println("Invalid date! - The date should be in the yyyy/MM/dd format.");
            return "";
        }
    }
}
