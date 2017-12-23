package com.roche.beneficios.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.roche.beneficios.entity.Contacto;
import com.roche.beneficios.entity.ContactoPK;
import com.roche.beneficios.model.ContactoModel;

@Component("contactoConverter")
public class ContactoConverter {
	@Autowired
	@Qualifier("empresaConverter")
	private EmpresaConverter empresaConverter;

	public Contacto modelToContacto(ContactoModel contactoModel) {

		if (contactoModel == null) {
			return null;
		}
		
		Contacto contacto = new Contacto();
		ContactoPK contactoPK = new ContactoPK();
		contactoPK.setIdContacto(contactoModel.getIdContacto());
		int codEmpresa = (contactoModel.getCodEmpresa() == 0) ? contactoModel.getEmpresa().getCodEmpresa() : contactoModel.getCodEmpresa();
		contactoPK.setCodEmpresa(codEmpresa);
		contacto.setId(contactoPK);
		contacto.setNomContacto(contactoModel.getNomContacto());
		contacto.setApContacto(contactoModel.getApContacto());
		contacto.setAmContacto(contactoModel.getAmContacto());
		contacto.setTelfContacto(contactoModel.getTelfContacto());
		contacto.setCorreoElec(contactoModel.getCorreoElec());
		contacto.setEmpresa(empresaConverter.modelToEmpresa(contactoModel.getEmpresa()));
		if (contacto.getEmpresa() != null) {
			contacto.getEmpresa().setContactos(null);
		}

		contacto.setBeneficios(contactoModel.getBeneficios());
		return contacto;
	}

	public ContactoModel contactoToModel(Contacto contacto) {

		if (contacto == null) {
			return null;
		}

		ContactoModel contactoModel = new ContactoModel();
		contactoModel.setIdContacto(contacto.getId().getIdContacto());
		contactoModel.setCodEmpresa(contacto.getId().getCodEmpresa());
		contactoModel.setNomContacto(contacto.getNomContacto());
		contactoModel.setApContacto(contacto.getApContacto());
		contactoModel.setAmContacto(contacto.getAmContacto());
		contactoModel.setTelfContacto(contacto.getTelfContacto());
		contactoModel.setCorreoElec(contacto.getCorreoElec());
		contactoModel.setEmpresa(empresaConverter.empresaToModel(contacto.getEmpresa()));
		if (contactoModel.getEmpresa() != null) {
			contactoModel.getEmpresa().setContactos(null);
		}
		contactoModel.setBeneficios(contacto.getBeneficios());
		return contactoModel;
	}
}