package com.exam.helper;

public class UserFoundException extends Exception {
    public UserFoundException() {
        super("User with this username found in database !! Try another username");
    }

    public UserFoundException(String msg) {
        super(msg);
    }
}
