package com.chamaruamasara;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeserializeEmail {
    public DeserializeEmail(String fileName) {
        try {
            //deserialize objects

            FileInputStream fis = new FileInputStream(fileName);
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
    }
}
