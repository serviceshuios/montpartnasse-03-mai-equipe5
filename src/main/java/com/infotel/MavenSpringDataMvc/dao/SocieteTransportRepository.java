package com.infotel.MavenSpringDataMvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.infotel.MavenSpringDataMvc.metier.SocieteTransport;

/**
 * 
 * repository de SocieteTransport
 *
 */

@Transactional
public interface SocieteTransportRepository extends JpaRepository <SocieteTransport, Integer>{
	
	
}
