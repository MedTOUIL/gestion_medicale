package org.o7planning.gestion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.o7planning.gestion.model.Malade;
import org.o7planning.gestion.repository.MaladeRepositry;
import org.o7planning.gestion.repository.MedecinRepository;

@Service
public class MaladeServiceImpl implements MaladeService{
	
	@Autowired
    private MaladeRepositry maladeRepository;

	@Override
	public List<Malade> getAllMalades() {
		return maladeRepository.findAll();
	}

	@Override
	public void saveMalade(Malade malade) {
		this.maladeRepository.save(malade);
	}

	@Override
	public Malade getMaladeById(long id) {
		Optional < Malade > optional = maladeRepository.findById(id);
        Malade malade = null;
        if (optional.isPresent()) {
        	malade = optional.get();
        } else {
            throw new RuntimeException(" Malade not found for id :: " + id);
        }
        return malade;
	}

	@Override
	public void deleteMaladeById(long id) {
		this.maladeRepository.deleteById(id);
	}

}
