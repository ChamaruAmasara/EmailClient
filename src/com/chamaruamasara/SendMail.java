package com.chamaruamasara;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;


public class SendMail {
    public SendMail(Email emailMessage) {
        System.out.println("Starting send!");

        String host = "email-smtp.ap-southeast-1.amazonaws.com";
        final String user = "AKIAXFXIUQNUMQ3X3K6Y";//SES IAM Username - this account can only send email through DoNotTrust@chamaru.me email
        final String password = "BLl4Gkqegu6w0p3YhkS/Y99EJ3LGtdMQknNU2nYtDQJQ";// SES IAM Password
        final String fromAddress = "DoNotTrust@chamaru.me"; //this account can only send email through DoNotTrust@chamaru.me email
        final String fromName = "Email Client by Chamaru";

        String to = emailMessage.recipientEmail();// Get to address from email object

        //Get the session object
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user, password);
                    }
                });

        //Compose the message
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromAddress, fromName));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(emailMessage.subject());
            message.setText(emailMessage.body());

            //send the message
            Transport.send(message);

            System.out.println("message sent successfully...");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
