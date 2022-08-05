package com.chamaruamasara;

public class Official extends Recipient{
    private String designation;

    public Official(String name, String email, String designation){

        setName(name);
        setEmail(email);
        setDesignation(designation);
    }

    public String getDesignation() {
        return designation;
    }

    private void setDesignation(String designation) {
        this.designation = designation;
    }
}
