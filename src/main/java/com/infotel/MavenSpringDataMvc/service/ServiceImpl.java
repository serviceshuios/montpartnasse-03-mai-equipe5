package com.infotel.MavenSpringDataMvc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infotel.MavenSpringDataMvc.dao.AerienneRepository;
import com.infotel.MavenSpringDataMvc.dao.RoutiereRepository;
import com.infotel.MavenSpringDataMvc.dao.SocieteTransportRepository;
import com.infotel.MavenSpringDataMvc.metier.Aerienne;
import com.infotel.MavenSpringDataMvc.metier.Cargaison;
import com.infotel.MavenSpringDataMvc.metier.Routiere;
import com.infotel.MavenSpringDataMvc.metier.SocieteTransport;

/**
 * 
 * déclaration des méthodes 
 *
 */
@Service (value="service")
public class ServiceImpl implements Iservice {
	
	@Autowired
	AerienneRepository aerienneRepository;
	@Autowired 
	RoutiereRepository routiereRepository;
	@Autowired
	SocieteTransportRepository societeTransportRepository;
	

	public AerienneRepository getAerienneRepository() {
		return aerienneRepository;
	}

	public void setAerienneRepository(AerienneRepository aerienneRepository) {
		this.aerienneRepository = aerienneRepository;
	}

	public RoutiereRepository getRoutiereRepository() {
		return routiereRepository;
	}

	public void setRoutiereRepository(RoutiereRepository routiereRepository) {
		this.routiereRepository = routiereRepository;
	}

	public SocieteTransportRepository getSocieteTransportRepository() {
		return societeTransportRepository;
	}

	public void setSocieteTransportRepository(SocieteTransportRepository societeTransportRepository) {
		this.societeTransportRepository = societeTransportRepository;
	}

	/**
	 * Méthode permettant d'ajouter une societe de transport
	 */
	
	@Override
	public SocieteTransport ajouterSocieteTransport(SocieteTransport st) {
		
		return societeTransportRepository.save(st);
	}

	/**
	 * Méthode permettant de modifier une societe de transport
	 */
	@Override
	public int modifierSocieteTransport(SocieteTransport st) {
		societeTransportRepository.save(st);
		return 1;
	}

	/**
	 * Méthode permettant de lister les societes de transport
	 */

	@Override
	public Iterable<SocieteTransport> findAllSocieteTransports() {
		
		return societeTransportRepository.findAll();
	}
	/**
	 * Méthode permettant d'afficher une societe de transport
	 */

	@Override
	public Optional<SocieteTransport> affichageSocieteTransport(int idSociete) {
		return societeTransportRepository.findById(idSociete);
	}

	/**
	 * Méthode permettant de supprimer une societe de transport
	 */
	@Override
	public void supprimerSocieteTransport(int idSociete) {
		societeTransportRepository.deleteById(idSociete);
	}

	/**
	 * Méthode permettant d'ajouter une cargaison routiere
	 */
	@Override
	public Routiere ajouterRoutiere(Routiere r) {
		
		return routiereRepository.save(r);
	}

	/**
	 * Méthode permettant de modifier une cargaison routiere
	 */
	@Override
	public int modifierRoutiere(Routiere r) {
		routiereRepository.save(r);
		return 1;
	}

	/**
	 * Méthode permettant de supprimer une cargaison routiere
	 */
	@Override
	public void supprimerRoutiere(int idCargaison) {
		routiereRepository.deleteById(idCargaison);
		
	}

	/**
	 * Méthode permettant de lister les cargaisons routieres
	 */
	@Override
	public Iterable<Routiere> findAllRoutieres() {
		// TODO Auto-generated method stub
		return routiereRepository.findAll();
	}

	/**
	 * Méthode permettant de lister les cargaisons routieres
	 */
	@Override
	public Optional<Routiere> affichageRoutiere(int idCargaison) {
		// TODO Auto-generated method stub
		return routiereRepository.findById(idCargaison);
	}

	/**
	 * Méthode permettant d'ajouter une cargaison aerienne
	 */
	@Override
	public Aerienne ajouterAerienne(Aerienne a) {
		// TODO Auto-generated method stub
		return aerienneRepository.save(a);
	}

	/**
	 * Méthode permettant de modifier une cargaison aerienne
	 */
	@Override
	public int modifierAerienne(Aerienne a) {
		aerienneRepository.save(a);
		return 1;
	}

	/**
	 * Méthode permettant de supprimer une cargaison aerienne
	 */
	@Override
	public void supprimerAerienne(int idCargaison) {
		aerienneRepository.deleteById(idCargaison);
		
	}

	/**
	 * Méthode permettant de lister les cargaisons aeriennes
	 */
	@Override
	public Iterable<Aerienne> findAllAeriennes() {
		// TODO Auto-generated method stub
		return aerienneRepository.findAll();
	}

	/**
	 * Méthode permettant d'afficher les cargaisons aeriennes
	 */
	@Override
	public Aerienne affichageAerienne(int idCargaison) {
		// TODO Auto-generated method stub
		return aerienneRepository.findById(idCargaison).get();
	}

	/**
	 * Methode permettant d'ajouter une cargaison à une societe
	 */
	@Override
	public int ajouterCargaisonSociete(int idSociete, int idCargaison) {
		routiereRepository.ajouterCargaisonSociete(idSociete, idCargaison);
		return idCargaison;
	}



}
