package com.springwebsite.task.Controllers;

import com.springwebsite.task.DAOs.Film;
import com.springwebsite.task.DAOs.FilmService;
import com.springwebsite.task.ResponseModels.ErrorModel;
import com.springwebsite.task.ResponseModels.FilmsResponse;
import com.springwebsite.task.ResponseModels.RandomSender;
import com.springwebsite.task.ResponseModels.SuccessModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MyController {
    @Autowired
    FilmService filmService;

    @PostMapping("/api/rand")
    public RandomSender getRandom() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i <= 30; i++) {
            list.add((int) (Math.random() * ((122 - 97) + 1)) + 97);
        }
        StringBuilder a = new StringBuilder();
        for (int item: list) {
            a.append((char) item);
        }
        return new RandomSender(a.toString());
    }

    @PostMapping(value = "api/addNewFilm")
    public SuccessModel addNewFilm(@RequestParam String name, @RequestParam String description, @RequestParam Double imdb) {
        filmService.createFilm(new Film(name, description, imdb.toString()));
        return new SuccessModel(1);
    }

    @GetMapping(value = "api/getFilms")
    public FilmsResponse getFilms() {
        List<Film> films = filmService.getFilms();
        return new FilmsResponse(films.size(), films);
    }

    @PostMapping(value = "api/deleteFilm")
    public SuccessModel deleteFilm(@RequestParam int id) {
        filmService.deleteFilm(id);
        return new SuccessModel(1);
    }

    @PostMapping(value = "api/edit")
    public SuccessModel editFilm(@RequestParam String name, @RequestParam String description, @RequestParam Double imdb, @RequestParam Integer id) {
        Film film = new Film(name, description, imdb.toString());
        film.setId(id);
        filmService.editFilm(film);
        return new SuccessModel(1);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ErrorModel onMissingArgument(MissingServletRequestParameterException e) {
        return new ErrorModel(500, "missing required param: " + e.getParameterName());
    }
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ErrorModel onInvalidArgType(MethodArgumentTypeMismatchException e) {
        return new ErrorModel(400, "Invalid type of " + e.getName());
    }
}
