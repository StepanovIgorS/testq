package com.springwebsite.task.ResponseModels;

import com.springwebsite.task.DAOs.Film;

import java.util.List;

public class FilmsResponse {
    public int count;
    public List<Film> films;

    public FilmsResponse(int count, List<Film> films) {
        this.count = count;
        this.films = films;
    }

    public int getCount() {
        return count;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }
}

