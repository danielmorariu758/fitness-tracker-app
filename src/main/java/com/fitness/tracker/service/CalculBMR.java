package com.fitness.tracker.service;

import com.fitness.tracker.model.Gen;

public class CalculBMR {
    public static double calculeazaBMR(double greutate, double inaltime, int varsta, Gen gen) {
        double baza = (10*greutate)+(6.25*inaltime)-(5*varsta);
        return gen == Gen.MASCULIN ? baza + 5 : baza - 161;
    }
}
