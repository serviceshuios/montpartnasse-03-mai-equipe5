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
	public Cargaison modifierCargaison(Cargaison c) {
		return cargaisonRepository.save(c);
		}

	@Override
	public void supprimerCargaison(int idCargaison) {
		cargaisonRepository.deleteById(idCargaison);
		
	}

	@Override
	public Iterable<Cargaison> findAllCargaisons() {
		
		return cargaisonRepository.findAll();
	}

	@Override
	public Cargaison affichageCargaison(int idCargaison) {
		
		return cargaisonRepository.findById(idCargaison).get();
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



}
