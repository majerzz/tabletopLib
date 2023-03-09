package com.example.tabletoplib.genres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class GenreController {
    @Autowired GenreService genreService;

    @GetMapping("/games/genres")
    public String showGameList(Model model){
        List<Genre> listGenres = genreService.listAllSorted();
        model.addAttribute("listGenres", listGenres);
        return "games_genres";
    }

    @GetMapping("games/genres/new")
    public String showNewForm(Model model){
        Genre genre = new Genre();
        model.addAttribute("genre", genre);
        model.addAttribute("pageTitle", "Добавить жанр");
        return "genre_form";
    }

    @PostMapping("/games/genres/save")
    public String saveGenre(Genre genre, RedirectAttributes ra){
        genreService.save(genre);
        ra.addFlashAttribute("message", "Жанр добавлена");
        return "redirect:/games/genres";
    }

    @GetMapping("games/genres/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra){
        try {
            Genre genre = genreService.get(id);
            model.addAttribute("genre", genre);
            model.addAttribute("pageTitle", "Редактировать жанр");
            return "genre_form";
        } catch (GenreNotFoundException e){
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/games/genres";
        }
    }

    @GetMapping("/games/genres/delete/{id}")
    public String deleteGenre(@PathVariable("id") Integer id, RedirectAttributes ra){
        try{
            genreService.delete(id);
            ra.addFlashAttribute("message", "Жанр с ID " + id + " удален");
        } catch (GenreNotFoundException e){
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/games/genres";
    }

}