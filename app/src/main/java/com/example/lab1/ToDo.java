package com.example.lab1;

public class ToDo {
    private String title;
    private String content;
    private double date;

    public ToDo( String title, String content, double date) {
        this.title = title;
        this.content = content;
        this.date = date;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public double getDate() {
        return date;
    }

    public void setDate(double date) {
        this.date = date;
    }
}
