package com.chamaruamasara;

import java.io.Serial;
import java.io.Serializable;

public record Email(String recipientEmail, String subject, String body, String dateTime) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1234567L;

}
