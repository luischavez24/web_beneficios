package com.roche.beneficios.services;

import java.util.List;

import com.roche.beneficios.model.ContactoModel;
import com.roche.beneficios.model.EmpresaModel;

public interface ContactosService {

	public abstract List<ContactoModel> listContactos();

	public abstract ContactoModel addContacto(ContactoModel contacto);

	public abstract int removeContacto(int idContacto, int codEmpresa);

	public abstract ContactoModel updateContacto(ContactoModel contacto);

	public abstract List<ContactoModel> listContactosByEmpresa(EmpresaModel empresa);

	public abstract List<ContactoModel> listAllByFullName(String busq);

	public abstract List<ContactoModel> listAllByFullNameAndEmpresa(String busq, EmpresaModel empresa);

	public abstract ContactoModel findContacto(int idContacto, int codEmpresa);
}
