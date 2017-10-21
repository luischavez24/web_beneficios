package com.roche.beneficios.services;

import java.util.List;

import com.roche.beneficios.entity.Distrito;

public interface DistritoService {
	public abstract Distrito findOne(int id);
	public abstract List<Distrito> listarDistrito ();
	
}
