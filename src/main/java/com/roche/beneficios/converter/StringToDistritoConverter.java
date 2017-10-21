package com.roche.beneficios.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.roche.beneficios.entity.Distrito;
import com.roche.beneficios.services.DistritoService;

@Component
public class StringToDistritoConverter implements Converter<String,Distrito>{
	@Autowired
	@Qualifier("distritoService")
	private DistritoService distritoService;
	
	@Override
	public Distrito convert(String source) {
		if (source != null) {
			try {
				Integer id = Integer.parseInt(source);
				return distritoService.findOne(id);
			}catch(Exception e) {
				return null;
			}
		}
		return null;
	}

}
