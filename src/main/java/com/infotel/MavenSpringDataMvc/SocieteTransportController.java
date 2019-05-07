package com.infotel.MavenSpringDataMvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.infotel.MavenSpringDataMvc.metier.Aerienne;
import com.infotel.MavenSpringDataMvc.metier.Cargaison;
import com.infotel.MavenSpringDataMvc.metier.Routiere;
import com.infotel.MavenSpringDataMvc.metier.SocieteTransport;
import com.infotel.MavenSpringDataMvc.service.Iservice;
/**
 * 
 * Handles requests for the application SocieteTransport
 *
 */

@Controller
public class SocieteTransportController {
	
	
	@Autowired
	private Iservice service;

	@RequestMapping(value = "/societe", method = RequestMethod.GET)
	public String lister(Model model) {
		model.addAttribute("societeTransport", new SocieteTransport());
		model.addAttribute("societeTransports", service.findAllSocieteTransports());
		return "societeTransport"; 
	}

	@RequestMapping(value = "/saveSociete")
	    public String save(SocieteTransport societeTransport,  Model model) {
	        if (societeTransport.getIdSociete() == 0) {
	            service.ajouterSocieteTransport(societeTransport);
	            model.addAttribute("societeTransport", new SocieteTransport());
	            model.addAttribute("societeTransports", service.findAllSocieteTransports());
	            return "societeTransport";
	        } else {
	            service.modifierSocieteTransport(societeTransport);
	            model.addAttribute("societeTransport", new SocieteTransport());
	            model.addAttribute("societeTransports", service.findAllSocieteTransports());
	            return "societeTransport";
	        }
	}

	@RequestMapping(value = "/deleteSociete")
    public String delete(@RequestParam int idSociete, Model model) {
        service.supprimerSocieteTransport(idSociete);
        model.addAttribute("societeTransport", new SocieteTransport());
        model.addAttribute("societeTransports", service.findAllSocieteTransports());
        return "societeTransport";
    }
    @RequestMapping(value = "/editSociete")
    public String edit(@RequestParam int idSociete, Model model) {
        model.addAttribute("societeTransport", service.affichageSocieteTransport(idSociete));
        model.addAttribute("societeTransports", service.findAllSocieteTransports());
        return "societeTransport";
    }
    
    
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String listerassociation(Model model) {
		model.addAttribute("societeTransport", new SocieteTransport());
		model.addAttribute("societeTransports", service.findAllSocieteTransports());
    	model.addAttribute("cargaisons", service.findAllCargaisons());

		return "update"; 
	}
	
    @RequestMapping(value = "/updateSave")
    public String association(@RequestParam int idSociete, @RequestParam int idCargaison, Model model) {
    	
    		 	service.ajouterCargaisonSociete(idSociete, idCargaison);

    	        model.addAttribute("societeTransports", service.findAllSocieteTransports());
    	    	model.addAttribute("cargaisons", service.findAllCargaisons());
    	 
    	    	return "update";
    	 
}}
