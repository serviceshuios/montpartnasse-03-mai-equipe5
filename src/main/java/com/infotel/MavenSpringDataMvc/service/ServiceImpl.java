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

	
	@Override
	public SocieteTransport ajouterSocieteTransport(SocieteTransport st) {
		
		return societeTransportRepository.save(st);
	}

	@Override
	public int modifierSocieteTransport(SocieteTransport st) {
		societeTransportRepository.save(st);
		return 1;
	}


	@Override
	public Iterable<SocieteTransport> findAllSocieteTransports() {
		
		return societeTransportRepository.findAll();
	}

	@Override
	public Optional<SocieteTransport> affichageSocieteTransport(int idSociete) {
		return societeTransportRepository.findById(idSociete);
	}

	@Override
	public void supprimerSocieteTransport(int idSociete) {
		societeTransportRepository.deleteById(idSociete);
	}

	@Override
	public Routiere ajouterRoutiere(Routiere r) {
		
		return routiereRepository.save(r);
	}

	@Override
	public int modifierRoutiere(Routiere r) {
		routiereRepository.save(r);
		return 1;
	}

	@Override
	public void supprimerRoutiere(int idCargaison) {
		routiereRepository.deleteById(idCargaison);
		
	}

	@Override
	public Iterable<Routiere> findAllRoutieres() {
		// TODO Auto-generated method stub
		return routiereRepository.findAll();
	}

	@Override
	public Optional<Routiere> affichageRoutiere(int idCargaison) {
		// TODO Auto-generated method stub
		return routiereRepository.findById(idCargaison);
	}

	@Override
	public Aerienne ajouterAerienne(Aerienne a) {
		// TODO Auto-generated method stub
		return aerienneRepository.save(a);
	}

	@Override
	public int modifierAerienne(Aerienne a) {
		aerienneRepository.save(a);
		return 1;
	}

	@Override
	public void supprimerAerienne(int idCargaison) {
		aerienneRepository.deleteById(idCargaison);
		
	}

	@Override
	public Iterable<Aerienne> findAllAeriennes() {
		// TODO Auto-generated method stub
		return aerienneRepository.findAll();
	}

	@Override
	public Aerienne affichageAerienne(int idCargaison) {
		// TODO Auto-generated method stub
		return aerienneRepository.findById(idCargaison).get();
	}



}
