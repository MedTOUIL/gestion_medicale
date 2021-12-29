package org.o7planning.gestion.service;


import java.util.List;

import  org.o7planning.gestion.model.Consultation;

public interface ConsultationService {

	List < Consultation > getAllConsultations();
    void saveConsultation(Consultation consultation);
    Consultation getConsultationById(long id);
    void deleteConsultationById(long id);
}
