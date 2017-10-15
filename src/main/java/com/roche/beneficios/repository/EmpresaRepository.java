package com.roche.beneficios.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roche.beneficios.entity.Empresa;

@Repository("empresaRepository")
public interface EmpresaRepository extends JpaRepository<Empresa, Serializable>{
	
	public abstract List<Empresa> findByRsEmpresaIgnoreCaseContaining(String rsEmpresa);
	
	public abstract List<Empresa> findByDireccionIgnoreCaseContaining(String direccion);
	
	public abstract List<Empresa> findByRucEmpresaIgnoreCaseContaining(String rucEmpresa);
	
	public abstract List<Empresa> findByTelfEmpresaIgnoreCaseContaining(String telfEmpresa);
	
	public abstract List<Empresa> findByNombreComercialIgnoreCaseContaining(String nombreComercial);
	
	public abstract Empresa findByRucEmpresa(String rucEmpresa);
}
