package com.roche.beneficios.services;

import java.util.List;

import com.roche.beneficios.model.EmpresaModel;

public interface EmpresaService {
	
	public abstract List<EmpresaModel> listarEmpresas ();
	
	public abstract EmpresaModel addEmpresa(EmpresaModel empresa);
	
	public abstract int removeEmpresa(String ruc);
	
	public abstract EmpresaModel updateEmpresa(EmpresaModel empresa);
	
	public abstract List<EmpresaModel> findByRuc(String ruc);
	
	public abstract List<EmpresaModel> findByNomComercial(String nomComercial);
	
	public abstract List<EmpresaModel> findByRSocial (String rSocial);
	
	public abstract EmpresaModel findOneByRuc(String ruc);
	
	public abstract EmpresaModel findByCodEmpresa(int codEmpresa);
}
