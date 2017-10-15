package com.roche.beneficios.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roche.beneficios.entity.Distrito;
@Repository("distritoRepository")
public interface DistritoRepository extends JpaRepository<Distrito, Serializable> {

}
