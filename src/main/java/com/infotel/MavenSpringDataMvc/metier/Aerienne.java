package com.infotel.MavenSpringDataMvc.metier;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.springframework.stereotype.Component;

/**
 * 
 * classe Aerienne qui herite de Cargaison
 *
 */
@Entity
@DiscriminatorValue("AERI")
@Component
public class Aerienne extends Cargaison {

	private String numVol;
	private double taxe;
	
	public String getNumVol() {
		return numVol;
	}
	public void setNumVol(String numVol) {
		this.numVol = numVol;
	}
	public double getTaxe() {
		return taxe;
	}
	public void setTaxe(double taxe) {
		this.taxe = taxe;
	}
	@Override
	public String toString() {
		return "Aerienne [numVol=" + numVol + ", taxe=" + taxe + "]";
	}
	
	
}
