package com.infotel.MavenSpringDataMvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.infotel.MavenSpringDataMvc.metier.Aerienne;
import com.infotel.MavenSpringDataMvc.metier.Cargaison;
import com.infotel.MavenSpringDataMvc.metier.Routiere;
import com.infotel.MavenSpringDataMvc.service.Iservice;

@Controller
public class CargaisonController {
	
	@Autowired
	private Iservice service;

	@RequestMapping(value = "/cargaison", method = RequestMethod.GET)
	public String lister(Model model) {
		model.addAttribute("cargaison", new Routiere());
		model.addAttribute("cargaison", new Aerienne());
		model.addAttribute("cargaisons", service.findAllCargaisons());
		return "cargaison"; 
	}

	@RequestMapping(value = "/saveCargaison")
	    public String save(Cargaison cargaison,  Model model) {
	        if (cargaison.getIdCargaison() == 0) {
	            service.ajouterCargaison(cargaison);
	            model.addAttribute("cargaison", new Routiere());
	    		model.addAttribute("cargaison", new Aerienne());
	            model.addAttribute("cargaisons", service.findAllCargaisons());
	            return "cargaison";
	        } else {
	            service.modifierCargaison(cargaison);
	            model.addAttribute("cargaison", new Routiere());
	    		model.addAttribute("cargaison", new Aerienne());
	            model.addAttribute("cargaisons", service.findAllCargaisons());
	            return "cargaison";
	        }
	}

	@RequestMapping(value = "/deleteCargaison")
    public String delete(@RequestParam int idCargaison, Model model) {
        service.supprimerCargaison(idCargaison);
        model.addAttribute("cargaison", new Routiere());
		model.addAttribute("cargaison", new Aerienne());
        model.addAttribute("cargaisons", service.findAllCargaisons());
        return "cargaison";
    }
    @RequestMapping(value = "/editCargaison")
    public String edit(@RequestParam int idCargaison, Model model) {
    	 model.addAttribute("cargaison", service.affichageCargaison(idCargaison));
         model.addAttribute("cargaisons", service.findAllCargaisons());
         return "cargaison";
    }
}
