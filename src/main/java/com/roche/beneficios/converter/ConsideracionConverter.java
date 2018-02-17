package com.roche.beneficios.converter;

import org.springframework.stereotype.Component;

import com.roche.beneficios.entity.Consideracion;
import com.roche.beneficios.entity.ConsideracionPK;
import com.roche.beneficios.model.ConsideracionModel;

@Component("consideracionConverter")
public class ConsideracionConverter {
	public Consideracion modelToConsideracion(ConsideracionModel entrada) {
		Consideracion salida = new Consideracion();
		ConsideracionPK pk = new ConsideracionPK();
		pk.setNroBeneficio(entrada.getNroBeneficio());
		pk.setNroConsideracion(entrada.getNroConsideracion());
		salida.setId(pk);
		salida.setConsideracion(entrada.getConsideracion());
		return salida;
	}
	
	public ConsideracionModel consideracionToModel(Consideracion entrada) {
		ConsideracionModel salida = new ConsideracionModel();
		salida.setNroBeneficio(entrada.getId().getNroConsideracion());
		salida.setNroConsideracion(entrada.getId().getNroConsideracion());
		salida.setConsideracion(entrada.getConsideracion());
		return salida;
	}
}
