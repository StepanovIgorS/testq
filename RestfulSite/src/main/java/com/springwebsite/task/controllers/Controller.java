package com.springwebsite.task.Controllers;

import com.springwebsite.task.DAOs.Film;
import com.springwebsite.task.DAOs.FilmService;
import com.springwebsite.task.ResponseModels.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ThController {

    @Autowired
    FilmService filmService;

    @GetMapping
    public String onJoin() {
        return "index";
    }

    @GetMapping(value = "/films")
    public String listTest(Model model) {
        List<Film> films = filmService.getFilms();
        if (!films.isEmpty()) {
            model.addAttribute("films", films);
            return "films";
        } else {
            return "addNew";
        }
    }

    @GetMapping(value = "/addNewFilm")
    public String addNewFilmForm() {
        return "addNew";
    }

    @GetMapping(value = "/edit/{id}")
    public String editFilm(@PathVariable Integer id, Model model) {
        Optional<Film> film = filmService.getFilm(id);
        if (film.isPresent()) {
            model.addAttribute("id", id);
            return "editfilm";
        } else {
            return "redirect:/error";
        }
    }

}
