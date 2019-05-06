package com.infotel.MavenSpringDataMvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.infotel.MavenSpringDataMvc.metier.Routiere;

/**
 * 
 * repository de Cargaison Routiere
 *
 */

@Transactional
public interface RoutiereRepository extends JpaRepository<Routiere, Integer>{

	@Modifying
	@Query("update Cargaison SET societeTransport.idSociete = :x where idCargaison = :y")
	public int ajouterPersonneAdresse(@Param("x") int idSociete, @Param("y") int idCargaison);
}
