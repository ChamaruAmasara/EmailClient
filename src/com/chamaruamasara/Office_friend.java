package com.chamaruamasara;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

public class Office_friend extends Official{
    private Date birthday;

    public Office_friend(String name,String email,String designation,String birthday){
        super(name,email,designation);
        try {
            setBirthday(birthday);
        } catch (ParseException e) {
            System.out.println("Invalid Birthday");
        }
    }



    public Date getBirthday() {
        return birthday;
    }

    private void setBirthday(String birthday) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date birthdayFormatted;
        birthdayFormatted = dateFormat.parse(birthday);
        this.birthday = birthdayFormatted;
    }
}
