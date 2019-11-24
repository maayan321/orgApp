package com.example.orgApp.objects;

import java.util.Date;

public class Report {
    private String text;
    private Date date;

    public Report(String text, Date date) {
        this.text = text;
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Report{" +
                "text='" + text + '\'' +
                ", date=" + date +
                '}';
    }
}
