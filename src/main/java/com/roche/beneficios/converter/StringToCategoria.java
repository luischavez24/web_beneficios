package com.roche.beneficios.converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.roche.beneficios.entity.Categoria;
import com.roche.beneficios.services.CategoriasService;

@Component
public class StringToCategoria implements Converter<String,Categoria> {

	@Autowired
	@Qualifier("categoriasService")
	private CategoriasService categoriasService;
	
	@Override
	public Categoria convert(String pk) {
		if (pk != null) {
			try {
				
				return categoriasService.findCategoria(Integer.parseInt(pk));
			
			} catch(Exception e) {
				return null;
			}
		}
		
		return null;
	}

}
