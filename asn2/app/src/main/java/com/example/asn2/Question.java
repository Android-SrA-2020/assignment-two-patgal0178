package com.example.asn2;

public class Question {
    private String qName;
    private boolean res;
    public Question(String name ,boolean val) {
        qName=name;
        res=val;
    }

    public boolean isRes() {
        return res;
    }
}
