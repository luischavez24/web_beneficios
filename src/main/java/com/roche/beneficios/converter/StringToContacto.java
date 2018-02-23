package com.roche.beneficios.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.roche.beneficios.model.ContactoModel;
import com.roche.beneficios.services.ContactosService;

@Component
public class StringToContacto implements Converter<String,ContactoModel>{
	@Autowired
	@Qualifier("contactosService")
	private ContactosService contactoService;

	@Override
	public ContactoModel convert(String source) {
		if (source != null) {
			try {
				String pk[] = source.split(",");
				if(pk.length == 2) {
					return contactoService.findContacto(Integer.parseInt(pk[0]), Integer.parseInt(pk[1]));
				}
			} catch(Exception e) {
				return null;
			}
		}
		return null;
	}

}
