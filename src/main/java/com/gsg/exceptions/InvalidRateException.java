package com.gsg.exceptions;

public class InvalidRateException extends RuntimeException {

    public InvalidRateException(String country) {
        super("Invalid or unmapped country: " + country);
    }
}
