package com.chamaruamasara;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class Recipient {
    private String name;
    private String email;

    //
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
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

        // if email is valid set email address
        if (result) this.email=email;
    }

}
