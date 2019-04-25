package com.movie.crawling.entity;

public class ContentImg {

    private String url;

    private String name;

    private int id;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ContentImg{" +
                "url='" + url + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
