package com.exam.helper;

public class SubjectFoundException extends Exception{
    public SubjectFoundException() {
        super("Subject with this name is already present");
    }

    public SubjectFoundException(String msg) {
        super(msg);
    }
}
