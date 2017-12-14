package com.roche.beneficios.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.roche.beneficios.converter.ContactoConverter;
import com.roche.beneficios.entity.Contacto;
import com.roche.beneficios.model.ContactoModel;
import com.roche.beneficios.repository.ContactosRepository;
import com.roche.beneficios.services.ContactosService;

@Service("contactosService")
public class ContactosServiceImpl implements ContactosService{
	
	private static final Log LOG = LogFactory.getLog(ContactosServiceImpl.class);
	
	@Autowired
	@Qualifier("contactosRepository")
	private ContactosRepository contactosRepository;
	
	@Autowired
	@Qualifier("contactoConverter")
	private ContactoConverter contactoConverter;
	
	@Override
	public List<ContactoModel> listContactos() {
		LOG.info("Listando Contactos");
		
		List<ContactoModel> listContactos = new ArrayList<>();
		
		contactosRepository.findAll().forEach((contacto) -> {
			listContactos.add(contactoConverter.contactoToModel(contacto));
		});
		
		LOG.info(listContactos);
		
		return listContactos;
	}

	@Override
	public ContactoModel addContacto(ContactoModel contacto) {
		Contacto contact = contactosRepository.save(contactoConverter.modelToContacto(contacto));
		return contactoConverter.contactoToModel(contact);
	}

	@Override
	public int removeContacto(int idContacto) {
		Contacto contacto = contactosRepository.findOne(idContacto);
		
		if(contacto != null) {
			
			contactosRepository.delete(contacto);
			
			return 1;
			
		}
		return 0;
	}

	@Override
	public ContactoModel updateContacto(ContactoModel contacto) {
		Contacto contact = contactosRepository.save(contactoConverter.modelToContacto(contacto));
		return contactoConverter.contactoToModel(contact);
	}

}
