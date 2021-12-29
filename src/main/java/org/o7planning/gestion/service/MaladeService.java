package org.o7planning.gestion.service;

import java.util.List;

import org.o7planning.gestion.model.Malade;

public interface MaladeService {
	
	List < Malade > getAllMalades();
    void saveMalade(Malade malade);
    Malade getMaladeById(long id);
    void deleteMaladeById(long id);

}
