package com.roche.beneficios.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.roche.beneficios.entity.CarouselBeneficios;
import com.roche.beneficios.model.CarouselBeneficiosModel;
import com.roche.beneficios.utils.ImageConvertor;

@Component("carouselBeneficiosConverter")
public class CarouselBeneficiosConverter{
	@Autowired
	@Qualifier("imageConvertor")
	private ImageConvertor imageConvertor;
	
	public CarouselBeneficiosModel entityToModel(CarouselBeneficios in) {
		CarouselBeneficiosModel out = new CarouselBeneficiosModel();
		out.setIdx(in.getIdx());
		out.setImagenB64(imageConvertor.convertToBase64(in.getImagen()));
		out.setNroBeneficio(in.getBeneficio().getNroBeneficio());
		
		return out;
	}
	
	public List<CarouselBeneficiosModel> entityToModelList(List<CarouselBeneficios> in) {
		List<CarouselBeneficiosModel> out = new ArrayList<>();
		in.forEach((cbeneficios) -> out.add(entityToModel(cbeneficios)));
		return out;
	}
}