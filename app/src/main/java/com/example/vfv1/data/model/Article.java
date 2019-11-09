package com.example.vfv1.data.model;

public class Article {
    public String author;
    public String title;
    public String userId;
    public String content;

    public Article(){

    }

    public Article(String author, String title, String userId, String content) {
        this.author = author;
        this.title = title;
        this.userId = userId;
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
