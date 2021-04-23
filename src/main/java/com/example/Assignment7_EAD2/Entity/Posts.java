package com.example.Assignment7_EAD2.Entity;

public class Posts {
    private int id;
    private int userId;
    private String title;
    private String content;
    private int likes;
    private int disLikes;

    public Posts() {
    }

    public Posts(int id, int userId, String title, String content, int likes, int disLikes) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.likes = likes;
        this.disLikes = disLikes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDisLikes() {
        return disLikes;
    }

    public void setDisLikes(int disLikes) {
        this.disLikes = disLikes;
    }

}

