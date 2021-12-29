package org.o7planning.gestion.controller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.o7planning.gestion.model.Consultation;
import org.o7planning.gestion.model.Malade;
import org.o7planning.gestion.service.ConsultationService;
import org.o7planning.gestion.service.MaladeService;
import org.o7planning.gestion.service.MedecinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MaladeController {
	
	@Autowired 
    private ConsultationService consultationService;
	
	@Autowired 
    private MedecinService medecinService;
	

	@Autowired 
    private MaladeService maladeService;
	
	// display list of medecins
    @GetMapping("/2")
    public String viewHomePage(Model model) {
        model.addAttribute("listMedecins", medecinService.getAllMedecins());
        return "index";
    }
    
 // display list of consultation
    @GetMapping("/index_consultation2")
    public String viewHomePage_Consultation(Model model) {
        model.addAttribute("listConsultations", consultationService.getAllConsultations());
        return "index_consultation";
    }
    
 // display list of Malade
    @GetMapping("/index_malade2")
    public String viewHomePage_Malade(Model model) {
        model.addAttribute("listMalades", maladeService.getAllMalades());
        return "index_malade";
    }
    
    @PostMapping("/saveMalade2")
    public String saveMalade2(@ModelAttribute("malade") Malade malade) {
        // save Malade to database
    	maladeService.saveMalade(malade);
        return "redirect:/index_malade";
    }
    
	 @GetMapping("/showNewMaladeForm2")
	    public String showNewMaladeForm2(Model model) {
	        // create model attribute to bind form data
	    	Malade malade = new Malade();
	        model.addAttribute("malade", malade);
	        return "new_malade";
	    }

	 @GetMapping("/showFormForUpdate2/{id}")
	    public String showFormForUpdate2(@PathVariable(value = "id") long id, Model model) {

	        // get Malade from the service
	    	Malade malade = maladeService.getMaladeById(id);

	        // set Malade as a model attribute to pre-populate the form
	        model.addAttribute("malade", malade);
	        return "update_malade";
	    }
	 
	 @GetMapping("/deleteMalade2/{id}")
	    public String deleteMalade(@PathVariable(value = "id") long id) {

	        // call delete Malade method 
	        this.maladeService.deleteMaladeById(id);
	        return "redirect:/index_malade";
	    }
	    

}
