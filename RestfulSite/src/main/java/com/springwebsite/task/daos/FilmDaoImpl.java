package com.springwebsite.task.DAOs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.net.FileNameMap;
import java.util.List;
import java.util.Optional;

@Repository
public class FilmDaoImpl implements FilmDAO{
    private static final String REQ = "SELECT * FROM films";
    private static final String NEW_FILM_REQ = "INSERT INTO films(name, description, imdb) VALUES(:name, :description, :imdb)";
    private static final String DEL_FILM_REQ = "DELETE FROM films WHERE id=:id";
    private static final String UPDATE_FILM_REQ = "UPDATE films SET name=:name, description=:description, imdb=:imdb WHERE id=:id";
    private static final String SELECT_FILM = "SELECT * FROM films WHERE id=:id";

    private final FilmMapper filmMapper;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public FilmDaoImpl(FilmMapper filmMapper, NamedParameterJdbcTemplate jdbcTemplate) {
        this.filmMapper = filmMapper;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<List<Film>> getFilms() {
        MapSqlParameterSource params = new MapSqlParameterSource();
        try {
            return Optional.of(
                    jdbcTemplate.query(REQ, params, filmMapper)
            );
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public void createFilm(Film film) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", film.getName());
        params.addValue("description", film.getDescription());
        params.addValue("imdb", film.getIMDB());
        jdbcTemplate.update(NEW_FILM_REQ, params);
    }

    @Override
    public void deleteFilm(int id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        jdbcTemplate.update(DEL_FILM_REQ, params);
    }
    @Override
    public void editFilm(Film film) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", film.getName());
        params.addValue("description", film.getDescription());
        params.addValue("imdb", film.getIMDB());
        params.addValue("id", film.getId());
        jdbcTemplate.update(UPDATE_FILM_REQ, params);
    }

    @Override
    public Optional<Film> getFilm(int id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        try {
            return Optional.ofNullable(
                    jdbcTemplate.queryForObject(SELECT_FILM, params, filmMapper)
            );
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }
}
