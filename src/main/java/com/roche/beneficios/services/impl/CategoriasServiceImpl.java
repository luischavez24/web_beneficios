package com.roche.beneficios.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.roche.beneficios.entity.Categoria;
import com.roche.beneficios.repository.CategoriasRepository;
import com.roche.beneficios.services.CategoriasService;

@Service("categoriasService")
public class CategoriasServiceImpl implements CategoriasService{

	@Autowired
	@Qualifier("categoriasRepository")
	private CategoriasRepository categoriasRepository;
	
	@Override
	public List<Categoria> listarCategorias() {
		return categoriasRepository.findAll();
	}

	@Override
	public Categoria findCategoria(int idCategoria) {
		
		return categoriasRepository.findOne(idCategoria);
	}

}
