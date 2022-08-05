package com.chamaruamasara;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Personal extends Recipient{
    private Date birthday;
    private String nickName;

    public Personal(String name, String nickName, String email, String birthday){
        setName(name);
        setNickName(nickName);
        setEmail(email);
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

    public String getNickName() {
        return nickName;
    }

    private void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
