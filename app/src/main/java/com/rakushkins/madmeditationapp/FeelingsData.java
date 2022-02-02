package com.rakushkins.madmeditationapp;

public class FeelingsData {
    private int id;
    private String title;
    private String image;
    private int position;

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public int getPosition() {
        return position;
    }
}
