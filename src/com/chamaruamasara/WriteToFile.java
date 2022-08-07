package com.chamaruamasara;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WriteToFile {
    public WriteToFile(Official officialContact){
        Writer("clientList.txt","Official: "+officialContact.getName()+","+officialContact.getEmail()+","+officialContact.getDesignation());
    }
    public WriteToFile(OfficeFriend officeFriendContact){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date birthday=officeFriendContact.getBirthday();
        Writer("clientList.txt", String.format("Office_friend: " + officeFriendContact.getName() + "," + officeFriendContact.getEmail() + "," + officeFriendContact.getDesignation() + ","+dateFormat.format(birthday)));
    }
    public WriteToFile(Personal personalContact){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date birthday=personalContact.getBirthday();
        Writer("clientList.txt","Personal: "+personalContact.getName()+","+personalContact.getNickName()+","+personalContact.getEmail()+","+dateFormat.format(birthday));
    }
    private void Writer(String fileName, String textToWrite){
        try{
            FileWriter writer = new FileWriter(fileName,true);
            writer.write(textToWrite+"\n");
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
