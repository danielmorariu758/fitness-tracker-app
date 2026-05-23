package com.fitness.tracker.dto;

import com.fitness.tracker.model.Gen;
import com.fitness.tracker.model.IntensitateAntrenament;
import com.fitness.tracker.model.NivelActivitate;
import com.fitness.tracker.model.Obiectiv;

public record DateSuplimentare(
        double greutate,
        double inaltime,
        int varsta,
        Gen gen,
        Obiectiv obiectiv,
        NivelActivitate nivelActivitate,
        int pasiZilnici,
        int numarAntrenamenteSaptamana,
        int durataAntrenament,
        IntensitateAntrenament intensitateAntrenament
) {}
