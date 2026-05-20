package com.fitness.tracker.controller;

import com.fitness.tracker.model.Gen;
import com.fitness.tracker.model.Obiectiv;
import com.fitness.tracker.model.UserProfile;
import com.fitness.tracker.repository.UserProfileRepository;
import com.fitness.tracker.service.FitnessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class HomeController {

    @Autowired
    private FitnessService fitnessService;

    @Autowired
    private UserProfileRepository userProfileRepository;

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
            Model model) {

        LocalDate dataNastereParsata = LocalDate.parse(dataNastere);

        UserProfile profil = new UserProfile(nume, dataNastereParsata, gen, greutate, inaltime, obiectiv);
        userProfileRepository.save(profil);

        double rezultatCalorii = fitnessService.calculeazaCaloriiZilnice(profil);

        model.addAttribute("numeUtilizator", nume);
        model.addAttribute("caloriiTarget", (int)rezultatCalorii);
        model.addAttribute("proteineTarget", (int)profil.getGreutate() * 2);

        return "rezultat";
    }
}
