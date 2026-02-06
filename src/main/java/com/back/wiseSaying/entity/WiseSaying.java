package com.back.wiseSaying.entity;

public class WiseSaying {
    private int id;
    private String saying;
    private String author;

    public WiseSaying(int id, String saying, String author) {
        this.id = id;
        this.saying = saying;
        this.author = author;
    }
    public boolean isNew() {
        return id == 0;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSaying(String saying) {
        this.saying = saying;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getSaying() {
        return saying;
    }

    public String getAuthor() {
        return author;
    }
}
