package org.o7planning.gestion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.o7planning.gestion.model.Medecin;
import org.o7planning.gestion.repository.MedecinRepository;

@Service
public class MedecinServiceImpl implements MedecinService {
	
	@Autowired
    private MedecinRepository medecinRepository;

	@Override
    public List < Medecin > getAllMedecins() {
        return medecinRepository.findAll();
    }

	@Override
    public void saveMedecin(Medecin medecin) {
        this.medecinRepository.save(medecin);
    }

    @Override
    public Medecin getMedecinById(long id) {
        Optional < Medecin > optional = medecinRepository.findById(id);
        Medecin medecin = null;
        if (optional.isPresent()) {
        	medecin = optional.get();
        } else {
            throw new RuntimeException(" Medecin not found for id :: " + id);
        }
        return medecin;
    }

    @Override
    public void deleteMedecinById(long id) {
        this.medecinRepository.deleteById(id);
    }

}
