package com.infotel.MavenSpringDataMvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.infotel.MavenSpringDataMvc.metier.Routiere;
import com.infotel.MavenSpringDataMvc.service.Iservice;

@Controller
public class RoutiereController {
	
	@Autowired
	private Iservice service;

	@RequestMapping(value = "/routiere", method = RequestMethod.GET)
	public String lister(Model model) {
		model.addAttribute("routiere", new Routiere());
		model.addAttribute("cargaisons", service.findAllCargaisons());
		return "routiere"; 
	}

	@RequestMapping(value = "/saveRoutiere")
	    public String save(Routiere routiere,  Model model) {
	        if (routiere.getIdCargaison() == 0) {
	            service.ajouterCargaison(routiere);
	            model.addAttribute("routiere", new Routiere());
	            model.addAttribute("cargaisons", service.findAllCargaisons());
	            return "routiere";
	            
	        } else {
	            service.modifierCargaison(routiere);
	            model.addAttribute("routiere", new Routiere());
	            model.addAttribute("cargaisons", service.findAllCargaisons());
	            return "routiere";
	        }
	}

	
	@RequestMapping(value = "/deleteRoutiere")
    public String delete(@RequestParam int idCargaison, Model model) {
        service.supprimerCargaison(idCargaison);
        model.addAttribute("routiere", new Routiere());
        model.addAttribute("cargaisons", service.findAllCargaisons());
        return "routiere";
    }
    @RequestMapping(value = "/editRoutiere")
    public String edit(@RequestParam int idCargaison, Model model) {
    	 model.addAttribute("routiere", service.affichageCargaison(idCargaison));
         model.addAttribute("cargaisons", service.findAllCargaisons());
         return "routiere";
    }
}

