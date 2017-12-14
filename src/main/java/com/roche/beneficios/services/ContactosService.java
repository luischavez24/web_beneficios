package com.roche.beneficios.services;

import java.util.List;

import com.roche.beneficios.model.ContactoModel;

public interface ContactosService {
	
	public abstract List<ContactoModel> listContactos();

	public abstract ContactoModel addContacto(ContactoModel contacto);

	public abstract int removeContacto(int idContacto);

	public abstract ContactoModel updateContacto(ContactoModel contacto);
}
