package com.springwebsite.task.DAOs;

import java.util.List;
import java.util.Optional;

public interface FilmService {
    public abstract void createFilm(Film film);
    public abstract List<Film> getFilms();
    public abstract void deleteFilm(int id);
    public abstract void editFilm(Film film);
    public abstract Optional<Film> getFilm(int id);
}
