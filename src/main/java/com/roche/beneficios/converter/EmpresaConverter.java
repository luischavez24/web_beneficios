package com.roche.beneficios.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.roche.beneficios.entity.Contacto;
import com.roche.beneficios.entity.Empresa;
import com.roche.beneficios.model.ContactoModel;
import com.roche.beneficios.model.EmpresaModel;

@Component("empresaConverter")
public class EmpresaConverter {
	@Autowired
	@Qualifier("contactoConverter") 
	private ContactoConverter contactoConverter;
	
	public Empresa modelToEmpresa(EmpresaModel empresaModel) {
		
		if(empresaModel == null) {
			return null;
		}
		
		List<Contacto> contactos = new ArrayList<>();
		
		empresaModel.getContactos().forEach((item) -> {
			item.setEmpresa(null);
			contactos.add(contactoConverter.modelToContacto(item));
		});
		
		Empresa empresa = new Empresa();
		empresa.setCodEmpresa(empresaModel.getCodEmpresa());
		empresa.setContactos(contactos);
		empresa.setDireccion(empresaModel.getDireccion());
		empresa.setRsEmpresa(empresaModel.getRsEmpresa());
		empresa.setNombreComercial(empresaModel.getNombreComercial());
		empresa.setRucEmpresa(empresaModel.getRucEmpresa());
		empresa.setTelfEmpresa(empresaModel.getTelfEmpresa());
		empresa.setDistrito(empresaModel.getDistrito());
		
		return empresa;
	}
	
	public EmpresaModel empresaToModel(Empresa empresa) {
		
		if(empresa == null) {
			return null;
		}
		
		List<ContactoModel> contactos = new ArrayList<>();
		
		empresa.getContactos().forEach((item) -> {
			item.setEmpresa(null);
			contactos.add(contactoConverter.contactoToModel(item));
		});
		
		EmpresaModel empresaModel = new EmpresaModel();
		empresaModel.setCodEmpresa(empresa.getCodEmpresa());
		empresaModel.setContactos(contactos);
		empresaModel.setDireccion(empresa.getDireccion());
		empresaModel.setRsEmpresa(empresa.getRsEmpresa());
		empresaModel.setNombreComercial(empresa.getNombreComercial());
		empresaModel.setRucEmpresa(empresa.getRucEmpresa());
		empresaModel.setTelfEmpresa(empresa.getTelfEmpresa());
		empresaModel.setDistrito(empresa.getDistrito());
		return empresaModel;
	}
}