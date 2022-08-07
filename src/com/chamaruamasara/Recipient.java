package com.chamaruamasara;

public class Recipient {
    private String name;
    private String email;

    static int count;

    Recipient() {
        count++;
    }

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
        this.email = email;
    }

}
