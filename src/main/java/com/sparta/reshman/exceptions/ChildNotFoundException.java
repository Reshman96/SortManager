package com.sparta.reshman.exceptions;

public class ChildNotFoundException extends Exception {

    @Override
    public String getMessage() {
        return "Child node does not exist!";
    }
}