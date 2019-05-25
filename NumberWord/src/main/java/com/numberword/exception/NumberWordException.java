package com.numberword.exception;

public class NumberWordException extends Exception {


    String message;
    public NumberWordException(String exceptionMessage, Exception ex) {
        super(ex);
        this.message = exceptionMessage;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
