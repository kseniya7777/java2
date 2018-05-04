package com.epam.kseniya_samokhina.java.lesson3.task1.Education;

import java.util.Date;

public class Student {
    private String firstName;
    private String secondName;
    private String curriculum;
    private Date startDate;

    public Student(String firstName, String secondName, String curriculum, Date startDate) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.curriculum = curriculum;
        this.startDate = startDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.secondName + " (" + this.curriculum + ")";
    }
}
