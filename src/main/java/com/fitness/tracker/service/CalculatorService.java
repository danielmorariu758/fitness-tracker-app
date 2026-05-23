package com.fitness.tracker.service;

import com.fitness.tracker.dto.MacroNutrienti;
import com.fitness.tracker.dto.RezultatMetabolic;
import com.fitness.tracker.model.*;

import java.time.LocalDate;
import java.time.Period;

public class CalculatorService {

    public static RezultatMetabolic proceseazaProfil(UserProfile profil,
                                              NivelActivitate nivel) {

        int varsta = Period.between(profil.getDataNastere(), LocalDate.now()).getYears();

        double bmrTemp = CalculBMR.calculeazaBMR(profil.getGreutate(),
                                                    profil.getInaltime(), varsta, profil.getGen());
        int totalBMR = (int)Math.round(bmrTemp);

        double pal = PalMapper.determinaPal(nivel);

        int tdee = (int)Math.round(pal * totalBMR);

        int caloriiTarget = tdee;
        if(profil.getObiectiv() == Obiectiv.SLABIRE) {
            int caloriiBrute = tdee - 500;
            int minimSiguranta = (profil.getGen() == Gen.FEMININ) ? 1300 : 1500;
            caloriiTarget = Math.max(caloriiBrute, minimSiguranta);
        } else if(profil.getObiectiv() == Obiectiv.MASA_MUSCULARA) {
            caloriiTarget = tdee + 300;
        }

        int grameProteine = (int)Math.round(profil.getGreutate() * 2.0);
        int caloriiProteine = grameProteine * 4;

        int caloriiGrasimi = (int)Math.round(caloriiTarget * 0.25);
        int grameGrasimi = (int)Math.round((double)caloriiGrasimi / 9);

        int caloriiCarb = caloriiTarget - (caloriiProteine + caloriiGrasimi);
        int grameCarb = (int)Math.round((double)caloriiCarb / 4);

        MacroNutrienti macro = new MacroNutrienti(grameProteine, grameGrasimi, grameCarb);

        return new RezultatMetabolic(totalBMR, tdee, caloriiTarget, pal,macro);
    }
}
