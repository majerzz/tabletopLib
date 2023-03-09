package com.example.tabletoplib.mechanics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MechanicController {
    @Autowired MechanicService mechanicService;

    @GetMapping("/games/mechanics")
    public String showGameList(Model model){
        List<Mechanic> listMechanics = mechanicService.listAllSorted();
        model.addAttribute("listMechanics", listMechanics);
        return "games_mechanics";
    }

    @GetMapping("games/mechanics/new")
    public String showNewForm(Model model){
        Mechanic mechanic = new Mechanic();
        model.addAttribute("mechanic", mechanic);
        model.addAttribute("pageTitle", "Добавить механику");
        return "mechanic_form";
    }

    @PostMapping("/games/mechanics/save")
    public String saveMechanic(Mechanic mechanic, RedirectAttributes ra){
        mechanicService.save(mechanic);
        ra.addFlashAttribute("message", "Механика добавлена");
        return "redirect:/games/mechanics";
    }

    @GetMapping("games/mechanics/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra){
        try {
            Mechanic mechanic = mechanicService.get(id);
            model.addAttribute("mechanic", mechanic);
            model.addAttribute("pageTitle", "Редактировать жанр");
            return "mechanic_form";
        } catch (MechanicNotFoundException e){
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/games/mechanics";
        }
    }

    @GetMapping("/games/mechanics/delete/{id}")
    public String deleteMechanic(@PathVariable("id") Integer id, RedirectAttributes ra){
        try{
            mechanicService.delete(id);
            ra.addFlashAttribute("message", "Механика с ID " + id + " удален");
        } catch (MechanicNotFoundException e){
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/games/mechanics";
    }

}