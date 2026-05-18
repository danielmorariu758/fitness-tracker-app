package com.fitness.tracker.service;

import com.fitness.tracker.model.Gen;
import com.fitness.tracker.model.Obiectiv;
import com.fitness.tracker.model.UserProfile;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class FitnessService {

    public double calculeazaCaloriiZilnice(UserProfile profil) {
        int varsta = Period.between(profil.getDataNastere(), LocalDate.now()).getYears();
        double bmr;

        //formula Mifflin-St Jeor
        if(profil.getGen() == Gen.MASCULIN) {
            bmr = (10 * profil.getGreutate()) + (6.25 * profil.getInaltime()) - (5 * varsta) + 5;
        } else {
            bmr = (10 * profil.getGreutate()) + (6.25 * profil.getInaltime()) - (5 * varsta) - 161;
        }

        double caloriiMentinere = bmr * 1.4;

        if(profil.getObiectiv() == Obiectiv.SLABIRE) {
            return caloriiMentinere - 500;
        } else if(profil.getObiectiv() == Obiectiv.MASA_MUSCULARA) {
            return caloriiMentinere + 300;
        } else {
            return caloriiMentinere;
        }
    }
}
