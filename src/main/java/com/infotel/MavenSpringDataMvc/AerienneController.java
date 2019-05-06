package com.infotel.MavenSpringDataMvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.infotel.MavenSpringDataMvc.metier.Aerienne;
import com.infotel.MavenSpringDataMvc.service.Iservice;

@Controller
public class AerienneController {
	
	
	@Autowired
	private Iservice service;

	@RequestMapping(value = "/aerienne", method = RequestMethod.GET)
	public String lister(Model model) {
		model.addAttribute("aerienne", new Aerienne());
	
		model.addAttribute("cargaisons", service.findAllCargaisons());
		return "aerienne"; 
	}

	@RequestMapping(value = "/saveAerienne")
	    public String save(Aerienne aerienne,  Model model) {
	        if (aerienne.getIdCargaison() == 0) {
	            service.ajouterCargaison(aerienne);
	            model.addAttribute("aerienne", new Aerienne());
	            model.addAttribute("cargaisons", service.findAllCargaisons());
	            return "aerienne";
	        } else {
	            service.modifierCargaison(aerienne);
	            model.addAttribute("aerienne", new Aerienne());
	            model.addAttribute("cargaisons", service.findAllCargaisons());
	            return "aerienne";
	        }
	}

	@RequestMapping(value = "/deleteAerienne")
    public String delete(@RequestParam int idCargaison, Model model) {
        service.supprimerCargaison(idCargaison);
        model.addAttribute("aerienne", new Aerienne());
        model.addAttribute("cargaisons", service.findAllCargaisons());
        return "aerienne";
    }
    @RequestMapping(value = "/editAerienne")
    public String edit(@RequestParam int idCargaison, Model model) {
    	 model.addAttribute("aerienne", service.affichageCargaison(idCargaison));
         model.addAttribute("cargaisons", service.findAllCargaisons());
         return "aerienne";
    }
}
