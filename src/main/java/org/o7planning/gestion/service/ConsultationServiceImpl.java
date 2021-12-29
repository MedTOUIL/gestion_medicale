package org.o7planning.gestion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.o7planning.gestion.model.Consultation;
import org.o7planning.gestion.repository.ConsultationRepository;

@Service
public class ConsultationServiceImpl implements ConsultationService{
	
	@Autowired
    private ConsultationRepository consultationRepository;

	@Override
	public List<Consultation> getAllConsultations() {
		return consultationRepository.findAll();
	}

	@Override
	public void saveConsultation(Consultation consultation) {
		this.consultationRepository.save(consultation);
	}

	@Override
	public Consultation getConsultationById(long id) {
		Optional < Consultation > optional = consultationRepository.findById(id);
		Consultation consultation = null;
        if (optional.isPresent()) {
        	consultation = optional.get();
        } else {
            throw new RuntimeException(" Consultation not found for id :: " + id);
        }
        return consultation;
	}

	@Override
	public void deleteConsultationById(long id) {
		this.consultationRepository.deleteById(id);
	}

}
