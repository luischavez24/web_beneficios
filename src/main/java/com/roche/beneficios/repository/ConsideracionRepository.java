package com.roche.beneficios.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roche.beneficios.entity.Consideracion;

@Repository("consideracionRepository")
public interface ConsideracionRepository extends JpaRepository<Consideracion, Serializable> {

}
