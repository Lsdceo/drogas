package com.drogas.sesi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.drogas.sesi.model.DrogaModel;

@Repository
public interface DrogaRepository extends JpaRepository <DrogaModel, Long> {
	
}