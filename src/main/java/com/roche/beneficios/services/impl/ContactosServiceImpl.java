package com.roche.beneficios.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.roche.beneficios.converter.ContactoConverter;
import com.roche.beneficios.converter.EmpresaConverter;
import com.roche.beneficios.entity.Contacto;
import com.roche.beneficios.entity.ContactoPK;
import com.roche.beneficios.entity.Empresa;
import com.roche.beneficios.model.ContactoModel;
import com.roche.beneficios.model.EmpresaModel;
import com.roche.beneficios.repository.ContactosRepository;
import com.roche.beneficios.repository.EmpresaRepository;
import com.roche.beneficios.services.ContactosService;


@Service("contactosService")
public class ContactosServiceImpl implements ContactosService {

	private static final Log LOG = LogFactory.getLog(ContactosServiceImpl.class);

	@Autowired
	@Qualifier("contactosRepository")
	private ContactosRepository contactosRepository;
	
	@Autowired
	@Qualifier("empresaRepository")
	private EmpresaRepository empresaRepository;

	@Autowired
	@Qualifier("contactoConverter")
	private ContactoConverter contactoConverter;

	@Autowired
	@Qualifier("empresaConverter")
	private EmpresaConverter empresaConverter;

	@Override
	public List<ContactoModel> listContactos() {
		LOG.info("Listando Contactos");

		List<ContactoModel> listContactos = new ArrayList<>();
		List<Contacto> entityList = contactosRepository.findAll();
		LOG.info("EntityList=" + entityList);
		entityList.forEach((contacto) -> {
			contacto.setEmpresa(empresaRepository.findOne(contacto.getId().getCodEmpresa()));
			listContactos.add(contactoConverter.contactoToModel(contacto));
			LOG.info("Empresa=" + contacto.getEmpresa());
		});

		LOG.info(listContactos);

		return listContactos;
	}

	@Override
	public ContactoModel addContacto(ContactoModel contacto) {

		Contacto insertContact = contactoConverter.modelToContacto(contacto);
		LOG.info("Contacto=" + insertContact);
		Contacto contact = contactosRepository.save(insertContact);
		LOG.info("Contacto=" + contact);
		return contactoConverter.contactoToModel(contact);
	}

	@Override
	public int removeContacto(int idContacto, int codEmpresa) {
		ContactoPK pkContacto = new ContactoPK();
		pkContacto.setIdContacto(idContacto);
		pkContacto.setCodEmpresa(codEmpresa);
		Contacto contacto = contactosRepository.findOne(pkContacto);

		if (contacto != null) {

			contactosRepository.delete(contacto);

			return 1;

		}
		return 0;
	}

	@Override
	public ContactoModel updateContacto(ContactoModel contacto) {

		Contacto contactoConvert = contactoConverter.modelToContacto(contacto);
		LOG.info("Contacto para actualizar=" + contactoConvert);
		Contacto contact = contactosRepository.save(contactoConvert);
		return contactoConverter.contactoToModel(contact);
	}

	@Override
	public List<ContactoModel> listContactosByEmpresa(EmpresaModel empresaModel) {

		List<ContactoModel> listContactos = new ArrayList<>();
		Empresa empresa = empresaConverter.modelToEmpresa(empresaModel);
		LOG.info("Empresa=" + empresa);
		List<Contacto> entityList = contactosRepository.findAllByEmpresa(empresa);
		LOG.info("EntityList=" + entityList);
		if (entityList != null) {
			entityList.forEach((contacto) -> {
				contacto.setEmpresa(empresaRepository.findOne(contacto.getId().getCodEmpresa()));
				listContactos.add(contactoConverter.contactoToModel(contacto));
				
			});
		}

		LOG.info("Listando por empresa=" + listContactos);

		return listContactos;
	}

	@Override
	public List<ContactoModel> listAllByFullName(String busq) {

		List<ContactoModel> listContactos = new ArrayList<>();
		contactosRepository.findAllByFullName(busq).forEach((contacto) -> {
			contacto.setEmpresa(empresaRepository.findOne(contacto.getId().getCodEmpresa()));
			listContactos.add(contactoConverter.contactoToModel(contacto));
		});

		LOG.info("Listando por fullName=" + listContactos);

		return listContactos;
	}

	@Override
	public List<ContactoModel> listAllByFullNameAndEmpresa(String busq, EmpresaModel empresa) {
		List<ContactoModel> listContactos = new ArrayList<>();
		Empresa empr = empresaConverter.modelToEmpresa(empresa);

		LOG.info("Buscando por la empresa = " + empr);

		List<Contacto> contacts = contactosRepository.findAllByFullNameAndEmpresa(busq, empr);
		LOG.info("Contatos = " + contacts);
		contacts.forEach((contacto) -> {
			contacto.setEmpresa(empr);
			listContactos.add(contactoConverter.contactoToModel(contacto));
		});

		LOG.info("Listando por fullNameAndEmpresa=" + listContactos);

		return listContactos;
	}

	public ContactoModel findContacto(int idContacto, int codEmpresa) {
		ContactoPK pkContacto = new ContactoPK();
		pkContacto.setIdContacto(idContacto);
		pkContacto.setCodEmpresa(codEmpresa);
		Contacto contacto = contactosRepository.findOne(pkContacto);
		LOG.info("Contacto=" + contacto);
		return contactoConverter.contactoToModel(contacto);
	}

}
