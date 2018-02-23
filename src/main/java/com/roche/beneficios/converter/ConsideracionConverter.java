package com.roche.beneficios.converter;

import java.util.ArrayList;
import java.util.List;

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
		salida.setNroBeneficio(entrada.getId().getNroBeneficio());
		salida.setNroConsideracion(entrada.getId().getNroConsideracion());
		salida.setConsideracion(entrada.getConsideracion());
		return salida;
	}
	
	public List<ConsideracionModel> stringToListModel(int nroBeneficio, String[] consideraciones) {
		List<ConsideracionModel> consModel = new ArrayList<>();
		
		for(int i = 0; i < consideraciones.length; i++){
			String cons = consideraciones[i];
			ConsideracionModel modelo = new ConsideracionModel();
			modelo.setNroBeneficio(nroBeneficio);
			modelo.setNroConsideracion(i + 1);
			modelo.setConsideracion(cons);
			consModel.add(modelo);
		};
		
		return consModel;
	}
}
