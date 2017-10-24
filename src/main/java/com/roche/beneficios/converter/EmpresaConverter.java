package com.roche.beneficios.converter;

import org.springframework.stereotype.Component;

import com.roche.beneficios.entity.Empresa;
import com.roche.beneficios.model.EmpresaModel;

@Component("empresaConverter")
public class EmpresaConverter {
	
	public Empresa modelToEmpresa(EmpresaModel empresaModel) {
		Empresa empresa = new Empresa();
		if(empresaModel.getContactos() != null) {
			empresaModel.getContactos().forEach(
					(contactoModel) -> {
						contactoModel.setEmpresa(null);
						contactoModel.setId(null);
					}
				);
		}
		empresa.setCodEmpresa(empresaModel.getCodEmpresa());
		empresa.setContactos(empresaModel.getContactos());
		empresa.setDireccion(empresaModel.getDireccion());
		empresa.setRsEmpresa(empresaModel.getRsEmpresa());
		empresa.setNombreComercial(empresaModel.getNombreComercial());
		empresa.setRucEmpresa(empresaModel.getRucEmpresa());
		empresa.setTelfEmpresa(empresaModel.getTelfEmpresa());
		empresa.setDistrito(empresaModel.getDistrito());
		return empresa;
	}
	
	public EmpresaModel empresaToModel(Empresa empresa) {
		EmpresaModel empresaModel = new EmpresaModel();
		if(empresa.getContactos() != null) {
			empresa.getContactos().forEach(
				(contacto) -> {
					contacto.setEmpresa(null);
					contacto.setId(null);
				}
			);
		}
		empresaModel.setCodEmpresa(empresa.getCodEmpresa());
		empresaModel.setContactos(empresa.getContactos());
		empresaModel.setDireccion(empresa.getDireccion());
		empresaModel.setRsEmpresa(empresa.getRsEmpresa());
		empresaModel.setNombreComercial(empresa.getNombreComercial());
		empresaModel.setRucEmpresa(empresa.getRucEmpresa());
		empresaModel.setTelfEmpresa(empresa.getTelfEmpresa());
		empresaModel.setDistrito(empresa.getDistrito());
		return empresaModel;
	}
}
