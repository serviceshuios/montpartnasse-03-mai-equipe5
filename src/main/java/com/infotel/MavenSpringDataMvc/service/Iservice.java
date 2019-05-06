package com.infotel.MavenSpringDataMvc.service;

import java.util.Optional;

import com.infotel.MavenSpringDataMvc.metier.Cargaison;
import com.infotel.MavenSpringDataMvc.metier.SocieteTransport;

public interface Iservice {
	public Cargaison ajouterCargaison (Cargaison c);
	public int modifierCargaison (Cargaison c);
	public void supprimerCargaison (int idCargaison);
	public Iterable<Cargaison> findAllCargaisons();
	public Cargaison affichageCargaison(int idCargaison);
	
	public SocieteTransport ajouterSocieteTransport (SocieteTransport st);
	public int modifierSocieteTransport (SocieteTransport st);
	public void supprimerSocieteTransport (int idSociete);
	public Iterable<SocieteTransport> findAllSocieteTransports();
	public Optional<SocieteTransport> affichageSocieteTransport(int idSociete);
	

}
