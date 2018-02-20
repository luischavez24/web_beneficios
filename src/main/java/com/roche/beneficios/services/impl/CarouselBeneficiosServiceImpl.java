package com.roche.beneficios.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.roche.beneficios.converter.CarouselBeneficiosConverter;
import com.roche.beneficios.model.CarouselBeneficiosModel;
import com.roche.beneficios.repository.CarouselBeneficiosRepository;
import com.roche.beneficios.services.CarouselBeneficiosService;

@Service("carouselBeneficiosService")
public class CarouselBeneficiosServiceImpl implements CarouselBeneficiosService{

	@Autowired
	@Qualifier("carouselBeneficiosRepository")
	private CarouselBeneficiosRepository carouselBeneficiosRepository;
	
	@Autowired
	@Qualifier("carouselBeneficiosConverter")
	private CarouselBeneficiosConverter carouselBeneficiosConverter;
	
	@Override
	public List<CarouselBeneficiosModel> listarItems() {
		return carouselBeneficiosConverter.entityToModelList(carouselBeneficiosRepository.findAll());
	}
	
}
