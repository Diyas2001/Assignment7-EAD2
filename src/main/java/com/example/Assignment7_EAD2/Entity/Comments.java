package com.example.Assignment7_EAD2.Entity;

public class Comments {
    private int id;
    private int userId;
    private int postId;
    private String comment;

    public Comments() {
    }

    public Comments(int id, int userId, int postId, String comment) {
        this.id = id;
        this.userId = userId;
        this.postId = postId;
        this.comment = comment;
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

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
