package com.roche.beneficios.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.roche.beneficios.converter.BeneficioConverter;
import com.roche.beneficios.entity.Beneficio;
import com.roche.beneficios.model.BeneficioModel;
import com.roche.beneficios.repository.BeneficiosRepository;
import com.roche.beneficios.repository.ConsideracionRepository;
import com.roche.beneficios.services.BeneficiosService;

@Service("beneficiosService")
public class BeneficiosServiceImpl implements BeneficiosService {
	
	@Autowired
	@Qualifier("beneficiosRepository")
	private BeneficiosRepository beneficiosRepository;
	
	@Autowired
	@Qualifier("consideracionRepository")
	private ConsideracionRepository consideracionRepository;
	
	@Autowired
	@Qualifier("beneficioConverter")
	private BeneficioConverter beneficioConverter;
	
	@Override
	public List<BeneficioModel> listarBeneficios() {
		List<BeneficioModel> listaBeneficios = new ArrayList<>();
		
		beneficiosRepository.findAll().forEach((bEntity) -> {
			listaBeneficios.add(beneficioConverter.modelToBeneficioLight(bEntity));
		});
		
		return listaBeneficios;
	}

	@Override
	public BeneficioModel insertarBeneficio(BeneficioModel beneficio) {
		Beneficio bEntity = beneficioConverter.modelToBeneficio(beneficio);
		Beneficio bEntitySave = beneficiosRepository.save(bEntity);
		bEntity.getConsideraciones().forEach((cons) -> {
			cons.getId().setNroBeneficio(bEntitySave.getNroBeneficio());
		});
		consideracionRepository.save(bEntity.getConsideraciones());
		
		return beneficioConverter.modelToBeneficio(bEntitySave);
	}

	@Override
	public BeneficioModel actualizarBeneficio(BeneficioModel beneficio) {
		Beneficio bEntity = beneficioConverter.modelToBeneficio(beneficio);
		Beneficio bEntitySave = beneficiosRepository.save(bEntity);
		bEntity.getConsideraciones().forEach((cons) -> {
			cons.getId().setNroBeneficio(bEntitySave.getNroBeneficio());
		});
		
		System.out.println(bEntity.getConsideraciones());
		
		consideracionRepository.save(bEntity.getConsideraciones());
		return beneficioConverter.modelToBeneficio(bEntitySave);
	}

	@Override
	public int eliminarBeneficio(int nroBeneficio) {
		beneficiosRepository.delete(nroBeneficio);
		return 1;
	}

	@Override
	public BeneficioModel findByNroBeneficio(int nroBeneficio) {
		Beneficio bEntity = beneficiosRepository.findByNroBeneficio(nroBeneficio);
		return beneficioConverter.modelToBeneficioHeavy(bEntity);
	}

	@Override
	public List<BeneficioModel> listarBeneficios(String descCategoria) {
		List<BeneficioModel> listaBeneficios = new ArrayList<>();
		
		beneficiosRepository.findByCategoriaDescCategoriaIgnoreCaseContaining(descCategoria).forEach((bEntity) -> {
			listaBeneficios.add(beneficioConverter.modelToBeneficioLight(bEntity));
		});
		return listaBeneficios;
	}

}
