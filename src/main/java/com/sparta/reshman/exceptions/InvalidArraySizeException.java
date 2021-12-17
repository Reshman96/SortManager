package com.sparta.reshman.exceptions;

public class InvalidArraySizeException extends Exception {

    @Override
    public String getMessage() {
        return "Array size cannot be less than two!";
    }
}
