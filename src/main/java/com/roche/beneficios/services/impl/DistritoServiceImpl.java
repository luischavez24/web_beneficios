package com.roche.beneficios.services.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.roche.beneficios.entity.Distrito;
import com.roche.beneficios.repository.DistritoRepository;
import com.roche.beneficios.services.DistritoService;

@Service("distritoService")
public class DistritoServiceImpl implements DistritoService{
	@Autowired
	@Qualifier("distritoRepository")
	private DistritoRepository distritoRepository;
	
	public List<Distrito> listarDistrito() {
		return distritoRepository.findAll();
	}
}
