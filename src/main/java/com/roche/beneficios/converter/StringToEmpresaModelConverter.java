package com.roche.beneficios.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.roche.beneficios.model.EmpresaModel;
import com.roche.beneficios.services.EmpresaService;

@Component
public class StringToEmpresaModelConverter implements Converter<String,EmpresaModel>{
	@Autowired
	@Qualifier("empresaService")
	private EmpresaService empresaService;

	@Override
	public EmpresaModel convert(String source) {
		if (source != null) {
			try {
				Integer id = Integer.parseInt(source);
				return empresaService.findByCodEmpresa(id);
			}catch(Exception e) {
				return null;
			}
		}
		return null;
	}
}
