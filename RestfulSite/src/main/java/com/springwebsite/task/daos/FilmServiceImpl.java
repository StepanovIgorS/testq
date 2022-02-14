package com.springwebsite.task.DAOs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Primary
@Service
public class FilmServiceImpl implements FilmService{
    private final FilmDAO filmDAO;

    @Autowired
    public FilmServiceImpl(FilmDAO filmDAO) {
        this.filmDAO = filmDAO;
    }

    @Override
    public void createFilm(Film film) {
        filmDAO.createFilm(film);
    }

    @Override
    public List<Film> getFilms() {
        return filmDAO.getFilms().orElseThrow(() -> new EmptyResultDataAccessException(1));
    }

    @Override
    public void deleteFilm(int id) {
        filmDAO.deleteFilm(id);
    }

    @Override
    public void editFilm(Film film) {
        filmDAO.editFilm(film);
    }

    @Override
    public Optional<Film> getFilm(int id) {
        return filmDAO.getFilm(id);
    }
}
