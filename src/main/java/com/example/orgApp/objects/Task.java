package com.example.orgApp.objects;

import java.util.Date;

public class Task {
    private String text;
    private Date assignDate;
    private Date dueDate;


    public Task(String text, Date assignDate, Date dueDate) {
        this.text = text;
        this.assignDate = assignDate;
        this.dueDate = dueDate;
    }

    public String getText() {
        return text;
    }

    public Date getAssignDate() {
        return assignDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "Task{" +
                "text='" + text + '\'' +
                ", assignDate=" + assignDate +
                ", dueDate=" + dueDate +
                '}';
    }
}
