package com.springwebsite.task.DAOs;

import java.util.List;
import java.util.Optional;

public interface FilmDAO {
    Optional<List<Film>> getFilms();
    void createFilm(Film film);
    void deleteFilm(int id);
    void editFilm(Film film);
    Optional<Film> getFilm(int id);
}
