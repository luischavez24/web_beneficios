package com.roche.beneficios.converter;


import org.springframework.stereotype.Component;

import com.roche.beneficios.entity.Contacto;
import com.roche.beneficios.model.ContactoModel;

@Component("contactoConverter")
public class ContactoConverter {

	public Contacto modelToContacto(ContactoModel contactoModel) {
		Contacto contacto = new Contacto();
		contacto.setNomContacto(contactoModel.getNomContacto());
		contacto.setApContacto(contactoModel.getApContacto());
		contacto.setAmContacto(contactoModel.getAmContacto());
		contacto.setTelfContacto(contactoModel.getTelfContacto());
		contacto.setEmpresa(contactoModel.getEmpresa());
		contacto.getEmpresa().setContactos(null);
		return contacto;
	}
	
	public ContactoModel contactoToModel(Contacto contacto) {
		ContactoModel contactoModel = new ContactoModel();
		contactoModel.setNomContacto(contacto.getNomContacto());
		contactoModel.setApContacto(contacto.getApContacto());
		contactoModel.setAmContacto(contacto.getAmContacto());
		contactoModel.setTelfContacto(contacto.getTelfContacto());
		contactoModel.setEmpresa(contacto.getEmpresa());
		contactoModel.getEmpresa().setContactos(null);
		return contactoModel;
	}
}
