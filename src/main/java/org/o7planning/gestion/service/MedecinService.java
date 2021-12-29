package org.o7planning.gestion.service;

import java.util.List;

import  org.o7planning.gestion.model.Medecin;

public interface MedecinService {
    List < Medecin > getAllMedecins();
    void saveMedecin(Medecin medecin);
    Medecin getMedecinById(long id);
    void deleteMedecinById(long id);
}
