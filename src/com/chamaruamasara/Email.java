package com.chamaruamasara;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Email implements Serializable {
    @Serial
    private static final long serialVersionUID = 1234567L;
    private final String recipientEmail;
    private final String subject;
    private final String body;
    private final String dateTime;

    public Email(String recipientEmail, String subject, String body, String dateTime) {
        this.recipientEmail = recipientEmail;
        this.subject = subject;
        this.body = body;
        this.dateTime = dateTime;
    }

    public String recipientEmail() {
        return recipientEmail;
    }

    public String subject() {
        return subject;
    }

    public String body() {
        return body;
    }

    public String dateTime() {
        return dateTime;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Email) obj;
        return Objects.equals(this.recipientEmail, that.recipientEmail) &&
                Objects.equals(this.subject, that.subject) &&
                Objects.equals(this.body, that.body) &&
                Objects.equals(this.dateTime, that.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipientEmail, subject, body, dateTime);
    }

    @Override
    public String toString() {
        return "Email[" +
                "recipientEmail=" + recipientEmail + ", " +
                "subject=" + subject + ", " +
                "body=" + body + ", " +
                "dateTime=" + dateTime + ']';
    }


}
