package com.fitness.tracker.service;

import com.fitness.tracker.model.NivelActivitate;

public class PalMapper {

    public static double determinaPal(NivelActivitate nivel) {
        switch(nivel) {
            case SEDENTAR:      return 1.20;
            case USOR_ACTIV:    return 1.375;
            case MODERAT_ACTIV: return 1.465;
            case FOARTE_ACTIV:  return 1.55;
            case EXTREM_ACTIV:  return 1.725;
            case ATLETIC:       return 1.90;
            default:            return 1.20;
        }
    }
}
