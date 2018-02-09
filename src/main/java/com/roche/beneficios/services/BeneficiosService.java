package com.roche.beneficios.services;

import java.util.List;

import com.roche.beneficios.model.BeneficioModel;

public interface BeneficiosService {
	
	public abstract BeneficioModel findByNroBeneficio(int nroBeneficio);
	
	public abstract List<BeneficioModel> listarBeneficios();
	
	public abstract BeneficioModel insertarBeneficio(BeneficioModel beneficio);
	
	public abstract BeneficioModel actualizarBeneficio(BeneficioModel beneficio);
	
	public abstract int eliminarBeneficio(int nroBeneficio);
}
