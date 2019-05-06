package com.infotel.MavenSpringDataMvc.metier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Table (name="Cargaison")
@Component
public abstract class Cargaison {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCargaison;
	protected String nomCargaison;
	protected String depart;
	protected String destination;
	
	
}
