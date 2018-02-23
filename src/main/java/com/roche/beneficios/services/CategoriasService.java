package com.roche.beneficios.services;

import java.util.List;

import com.roche.beneficios.entity.Categoria;

public interface CategoriasService {
	
	public abstract List<Categoria> listarCategorias();
	
	public abstract Categoria findCategoria(int idCategoria);
}
