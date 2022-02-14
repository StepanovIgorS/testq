package com.springwebsite.task.DAOs;

public class Film {
    private int id;
    private String name;
    private String description;
    private String IMDB;

    public Film(String name, String description, String IMDB) {
        this.name = name;
        this.description = description;
        this.IMDB = IMDB;
    }
    public Film() {}

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getIMDB() {
        return IMDB;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIMDB(String IMDB) {
        this.IMDB = IMDB;
    }

    public void setId(int id) {
        this.id = id;
    }
}
