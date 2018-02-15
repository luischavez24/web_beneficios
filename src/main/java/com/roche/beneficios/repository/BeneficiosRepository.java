package com.roche.beneficios.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roche.beneficios.entity.Beneficio;

@Repository("beneficiosRepository")
public interface BeneficiosRepository extends JpaRepository<Beneficio, Serializable>{
	
	public abstract Beneficio findByNroBeneficio(int nroBeneficio);
	
	public abstract List<Beneficio> findByCategoriaDescCategoriaIgnoreCaseContaining(String descCategoria);
	
}
