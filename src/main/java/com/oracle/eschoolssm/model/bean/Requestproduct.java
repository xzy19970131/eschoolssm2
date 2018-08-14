package com.oracle.eschoolssm.model.bean;

public class Requestproduct {
    private int requestproid;
    private String name;
    private String message;
    private String image;
    private Fenlei fenlei;
    private User user;

    public int getRequestproid() {
        return requestproid;
    }

    public void setRequestproid(int requestproid) {
        this.requestproid = requestproid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Fenlei getFenlei() {
        return fenlei;
    }

    public void setFenlei(Fenlei fenlei) {
        this.fenlei = fenlei;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
