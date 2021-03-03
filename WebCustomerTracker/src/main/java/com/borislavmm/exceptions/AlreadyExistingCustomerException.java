package com.borislavmm.exceptions;

public class AlreadyExistingCustomerException extends RuntimeException{
    public AlreadyExistingCustomerException(String message) {
        super(message);
    }

    public AlreadyExistingCustomerException(String message, Throwable cause) {
        super(message, cause);
    }

    public AlreadyExistingCustomerException(Throwable cause) {
        super(cause);
    }
}
