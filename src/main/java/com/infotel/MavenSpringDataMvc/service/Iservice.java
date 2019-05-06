package com.infotel.MavenSpringDataMvc.service;

/**
 * Interface de la classe serviceImpl
 */
import java.util.Optional;

import com.infotel.MavenSpringDataMvc.metier.Aerienne;
import com.infotel.MavenSpringDataMvc.metier.Routiere;
import com.infotel.MavenSpringDataMvc.metier.SocieteTransport;

public interface Iservice {
	public Routiere ajouterRoutiere (Routiere r);
	public int modifierRoutiere (Routiere r);
	public void supprimerRoutiere (int idCargaison);
	public Iterable<Routiere> findAllRoutieres();
	public Optional<Routiere> affichageRoutiere(int idCargaison);
	
	public Aerienne ajouterAerienne (Aerienne a);
	public int modifierAerienne (Aerienne a);
	public void supprimerAerienne (int idCargaison);
	public Iterable<Aerienne> findAllAeriennes();
	public Aerienne affichageAerienne(int idCargaison);
	
	public SocieteTransport ajouterSocieteTransport (SocieteTransport st);
	public int modifierSocieteTransport (SocieteTransport st);
	public void supprimerSocieteTransport (int idSociete);
	public Iterable<SocieteTransport> findAllSocieteTransports();
	public Optional<SocieteTransport> affichageSocieteTransport(int idSociete);
	

}
