package org.o7planning.gestion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.o7planning.gestion.model.Medecin;
import org.o7planning.gestion.service.ConsultationService;
import org.o7planning.gestion.service.MaladeService;
import org.o7planning.gestion.service.MedecinService;

@Controller
public class MedecinController {
	
	@Autowired 
    private MedecinService medecinService;
	
	@Autowired 
    private ConsultationService consultationService;

	@Autowired 
    private MaladeService maladeService;
	
	
	// display list of medecins
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listMedecins", medecinService.getAllMedecins());
        return "index";
    }
    
    // display list of consultation
    @GetMapping("/index_consultation")
    public String viewHomePage_Consultation(Model model) {
        model.addAttribute("listConsultations", consultationService.getAllConsultations());
        return "index_consultation";
    }
    
 // display list of Malade
    @GetMapping("/index_malade")
    public String viewHomePage_Malade(Model model) {
        model.addAttribute("listMalades", maladeService.getAllMalades());
        return "index_malade";
    }

    @GetMapping("/showNewMedecinForm")
    public String showNewMedecinForm(Model model) {
        // create model attribute to bind form data
    	Medecin medecin = new Medecin();
        model.addAttribute("medecin", medecin);
        return "new_medecin";
    }
    
    @PostMapping("/saveMedecin")
    public String saveMedecin(@ModelAttribute("medecin") Medecin medecin) {
        // save medecin to database
    	medecinService.saveMedecin(medecin);
        return "redirect:/";
    }
    
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get medecin from the service
    	Medecin medecin = medecinService.getMedecinById(id);

        // set medecin as a model attribute to pre-populate the form
        model.addAttribute("medecin", medecin);
        return "update_medecin";
    }
    
    @GetMapping("/deleteMedecin/{id}")
    public String deleteMedecin(@PathVariable(value = "id") long id) {

        // call delete medecin method 
        this.medecinService.deleteMedecinById(id);
        return "redirect:/";
    }

}
