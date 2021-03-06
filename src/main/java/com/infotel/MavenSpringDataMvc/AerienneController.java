package com.infotel.MavenSpringDataMvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.infotel.MavenSpringDataMvc.metier.Aerienne;
import com.infotel.MavenSpringDataMvc.service.Iservice;

/**
 * Handles requests for the application Aerienne
 */

@Controller
public class AerienneController {
	
	
	@Autowired
	private Iservice service;
	
	@RequestMapping(value = "/aerienne", method = RequestMethod.GET)
	public String lister(Model model) {
		model.addAttribute("aerienne", new Aerienne());
		model.addAttribute("cargaisons", service.findAllAeriennes());
		return "aerienne"; 
	}

	/**
	 * ajout/modif d'une cargaison Aerienne
	 */
	@RequestMapping(value = "/saveAerienne")
	    public String save(Aerienne aerienne,  Model model) {
	        if (aerienne.getIdCargaison() == 0) {
	            service.ajouterAerienne(aerienne);
	            model.addAttribute("aerienne", new Aerienne());
	            model.addAttribute("aeriennes", service.findAllAeriennes());
	            return "aerienne";
	        } else {
	            service.modifierAerienne(aerienne);
	            model.addAttribute("aerienne", new Aerienne());
	            model.addAttribute("aeriennes", service.findAllAeriennes());
	            return "aerienne";
	        }
	}
	
	/**
	 * suppression d'une cargaison Aerienne
	 */
	@RequestMapping(value = "/deleteAerienne")
    public String delete(@RequestParam int idCargaison, Model model) {
        service.supprimerAerienne(idCargaison);
        model.addAttribute("aerienne", new Aerienne());
        model.addAttribute("aeriennes", service.findAllAeriennes());
        return "aerienne";
    }
	
	/**
	 * get des infos d'une cargaison Aerienne
	 */
    @RequestMapping(value = "/editAerienne")
    public String edit(@RequestParam int idCargaison, Model model) {
    	 model.addAttribute("aerienne", service.affichageAerienne(idCargaison));
    	 model.addAttribute("aeriennes", service.findAllAeriennes());
    	 return "aerienne";
    }
}
