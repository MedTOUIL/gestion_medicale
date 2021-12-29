package org.o7planning.gestion.controller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.o7planning.gestion.model.Consultation;
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
public class ConsultationController {
	
	@Autowired 
    private ConsultationService consultationService;
	
	@Autowired 
    private MedecinService medecinService;
	

	@Autowired 
    private MaladeService maladeService;
	
	// display list of medecins
    @GetMapping("/1")
    public String viewHomePage(Model model) {
        model.addAttribute("listMedecins", medecinService.getAllMedecins());
        return "index";
    }
    
    // display list of malade
    @GetMapping("/index_malade1")
    public String viewHomePage_Malade(Model model) {
        model.addAttribute("listMalades", maladeService.getAllMalades());
        return "index_malade";
    }
	
	// display list of consultation
    @GetMapping("/index_consultation1")
    public String viewHomePage_Consultation(Model model) {
        model.addAttribute("listConsultations", consultationService.getAllConsultations());
        return "index_consultation";
    }
    
    @GetMapping("/showNewConsultationForm1")
    public String showNewConsultationForm1(Model model) {
        // create model attribute to bind form data
    	Consultation consultation = new Consultation();
        model.addAttribute("consultation", consultation);
        return "new_consultation";
    }

    @PostMapping("/saveConsultation1")
    public String saveConsultation1(@ModelAttribute("consultation") Consultation consultation) {
        // save Consultation to database
    	consultationService.saveConsultation(consultation);
        return "redirect:/index_consultation";
    }
    
    @GetMapping("/showFormForUpdate1/{id}")
    public String showFormForUpdate1(@PathVariable(value = "id") long id, Model model) {

        // get Consultation from the service
    	Consultation consultation = consultationService.getConsultationById(id);

        // set Consultation as a model attribute to pre-populate the form
        model.addAttribute("consultation", consultation);
        return "update_consultation";
    }
    
    @GetMapping("/deleteConsultation1/{id}")
    public String deleteConsultation(@PathVariable(value = "id") long id) {

        // call delete Consultation method 
        this.consultationService.deleteConsultationById(id);
        return "redirect:/index_consultation";
    }
    
    

}
