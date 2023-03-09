package com.example.tabletoplib.games;

import com.example.tabletoplib.genres.Genre;
import com.example.tabletoplib.genres.GenreService;
import com.example.tabletoplib.mechanics.Mechanic;
import com.example.tabletoplib.mechanics.MechanicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class GameController {
    @Autowired GameService service;
    @Autowired
    GenreService genreService;
    @Autowired
    MechanicService mechanicService;

    @GetMapping("/games")
    public String showGameList(Model model){
        List<Game> listGames = service.listAll();
        model.addAttribute("listGames", listGames);
        return "games";
    }

    @GetMapping("games/new")
    public String showNewForm(Model model){
        Game game = new Game();
        List<Genre> listGenres = genreService.listAllSorted();
        List<Mechanic> listMechanics = mechanicService.listAllSorted();
        model.addAttribute("game", game);
        model.addAttribute("pageTitle", "Добавить игру");
        model.addAttribute("genres", listGenres);
        model.addAttribute("mechanics", listMechanics);
        return "game_form";
    }

    @PostMapping("/games/save")
    public String saveGame(Game game, RedirectAttributes ra){
        service.save(game);
        ra.addFlashAttribute("message", "Игра добавлена");
        return "redirect:/games";
    }

    @GetMapping("/games/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra){
        try {
            List<Genre> listGenres = genreService.listAllSorted();
            List<Mechanic> listMechanics = mechanicService.listAllSorted();
            Game game = service.get(id);
            model.addAttribute("game", game);
            model.addAttribute("pageTitle", "Редактировать игру");
            model.addAttribute("genres", listGenres);
            model.addAttribute("mechanics", listMechanics);
            return "game_form";
        } catch (GameNotFoundException e){
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/games";
        }
    }

    @GetMapping("/games/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, RedirectAttributes ra){
        try{
            service.delete(id);
            ra.addFlashAttribute("message", "Игра с ID " + id + " удалена");
        } catch (GameNotFoundException e){
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/games";
    }


}
