package com.infotel.MavenSpringDataMvc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infotel.MavenSpringDataMvc.dao.CargaisonRepository;
import com.infotel.MavenSpringDataMvc.dao.SocieteTransportRepository;
import com.infotel.MavenSpringDataMvc.metier.Cargaison;
import com.infotel.MavenSpringDataMvc.metier.SocieteTransport;

@Service (value="service")
public class ServiceImpl implements Iservice {
	
	@Autowired
	CargaisonRepository cargaisonRepository;
	@Autowired
	SocieteTransportRepository societeTransportRepository;
	
	

	public CargaisonRepository getCargaisonrepository() {
		return cargaisonRepository;
	}

	public void setCargaisonrepository(CargaisonRepository cargaisonrepository) {
		this.cargaisonRepository = cargaisonrepository;
	}

	public SocieteTransportRepository getSocieteTransportrepository() {
		return societeTransportRepository;
	}

	public void setSocieteTransportrepository(SocieteTransportRepository societeTransportrepository) {
		this.societeTransportRepository = societeTransportrepository;
	}

	@Override
	public Cargaison ajouterCargaison(Cargaison c) {
		
		return cargaisonRepository.save(c);
	}

	@Override
	public int modifierCargaison(Cargaison c) {
		cargaisonRepository.save(c);
		return 1;
	}

	@Override
	public void supprimerCargaison(int idCargaison) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterable<Cargaison> findAllCargaisons() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Cargaison> affichageCargaison(int idCargaison) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cargaison ajouterSocieteTransport(SocieteTransport st) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int modifierSocieteTransport(SocieteTransport st) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public Iterable<SocieteTransport> findAllSocieteTransports() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<SocieteTransport> affichageSocieteTransport(int idSociete) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void supprimerSocieteTransport(int idSociete) {
		// TODO Auto-generated method stub
		
	}



}
