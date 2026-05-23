package com.fitness.tracker.controller;

import com.fitness.tracker.dto.RezultatMetabolic;
import com.fitness.tracker.model.*;
import com.fitness.tracker.repository.UserProfileRepository;
import com.fitness.tracker.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class HomeController {

    @GetMapping("/")
    public String pornire() {
        return "index";
    }

    @PostMapping("/calcul")
    public String proceseazaCalcul(
            @RequestParam String nume,
            @RequestParam String dataNastere,
            @RequestParam Gen gen,
            @RequestParam double greutate,
            @RequestParam int inaltime,
            @RequestParam Obiectiv obiectiv,
            @RequestParam NivelActivitate nivelActivitate,

            Model model) {

        LocalDate dataNastereParsata = LocalDate.parse(dataNastere);

        UserProfile profil = new UserProfile(nume, dataNastereParsata, gen, greutate, inaltime, obiectiv);

        RezultatMetabolic rezultatMeta = CalculatorService.proceseazaProfil(
                profil, nivelActivitate);

        model.addAttribute("numeUtilizator", nume);
        model.addAttribute("caloriiTarget", rezultatMeta.caloriiTinta());
        model.addAttribute("proteineTarget", rezultatMeta.macro().grameProteine());
        model.addAttribute("bmr", rezultatMeta.bmr());
        model.addAttribute("tdee", rezultatMeta.tdee());
        model.addAttribute("pal", rezultatMeta.valoarePal());

        return "rezultat";
    }
}
