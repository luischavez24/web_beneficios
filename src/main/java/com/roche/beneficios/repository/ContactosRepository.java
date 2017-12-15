package com.roche.beneficios.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.roche.beneficios.entity.Contacto;
import com.roche.beneficios.entity.Empresa;
@Repository("contactosRepository")
public interface ContactosRepository extends JpaRepository<Contacto, Serializable> {
	
	public List<Contacto> findAllByEmpresa(Empresa empresa);
	
	@Query("SELECT c FROM Contacto c WHERE "
			+ "LOWER(c.nomContacto) like CONCAT('%',LOWER(:fullName),'%')"
			+ "or LOWER(c.apContacto) like CONCAT('%',LOWER(:fullName),'%') "
			+ "or LOWER(c.amContacto) like CONCAT('%',LOWER(:fullName),'%') "
			+ "or LOWER(CONCAT(c.nomContacto,' ', c.apContacto,' ', c.amContacto)) "
			+ "like CONCAT('%',LOWER(:fullName),'%')")
	public List<Contacto> findAllByFullName(@Param("fullName") String fullName);

}
