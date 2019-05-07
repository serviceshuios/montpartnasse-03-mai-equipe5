package com.infotel.MavenSpringDataMvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.infotel.MavenSpringDataMvc.metier.Cargaison;

@Transactional
public interface CargaisonRepository extends JpaRepository<Cargaison, Integer>{
	
	@Modifying
	@Query("update Cargaison SET societeTransport.idSociete = :x where idCargaison = :y")
	public int ajouterCargaisonSociete(@Param("x") int idSociete, @Param("y") int idCargaison);
	
//	@Modifying
//	@Query("update Cargaison c SET c.societeTransport.idSociete = ?1 where c.idCargaison = ?2")
//	public int ajouterCargaisonSociete( int idSociete, int idCargaison);
}
