package com.chamaruamasara;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class ValidateEmail {

    //validate Email Addresses
    public static boolean ValidateEmail(String email) {

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
}
