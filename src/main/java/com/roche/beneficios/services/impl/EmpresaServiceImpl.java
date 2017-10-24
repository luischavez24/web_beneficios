package com.roche.beneficios.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.roche.beneficios.converter.EmpresaConverter;
import com.roche.beneficios.entity.Empresa;
import com.roche.beneficios.model.EmpresaModel;
import com.roche.beneficios.repository.EmpresaRepository;
import com.roche.beneficios.services.EmpresaService;
@Service("empresaService")
public class EmpresaServiceImpl implements EmpresaService{
	
	@Autowired
	@Qualifier("empresaConverter")
	private EmpresaConverter empresaConverter;
	
	@Autowired
	@Qualifier("empresaRepository")
	private EmpresaRepository empresaRepository;
	
	@Override
	public List<EmpresaModel> listarEmpresas() {
		List<EmpresaModel> empresas = new ArrayList<>();
		empresaRepository.findAll().forEach((empresa) -> empresas.add(empresaConverter.empresaToModel(empresa)));
		return empresas;
	}

	@Override
	public EmpresaModel addEmpresa(EmpresaModel empresa) {
		Empresa empresaRe = empresaConverter.modelToEmpresa(empresa);
		empresaRepository.save(empresaRe);
		return empresaConverter.empresaToModel(empresaRe);
	}

	@Override
	public int removeEmpresa(String ruc) {
		Empresa empresa = empresaRepository.findByRucEmpresa(ruc);
		if(empresa != null) {
			empresaRepository.delete(empresa);
		}
		return 0;
	}

	@Override
	public EmpresaModel updateEmpresa(EmpresaModel empresa) {
		return empresaConverter.empresaToModel(empresaRepository.save(empresaConverter.modelToEmpresa(empresa)));
	}

	@Override
	public List<EmpresaModel> findByRuc(String ruc) {
		List<EmpresaModel> lista = new ArrayList<>();
		empresaRepository.findByRucEmpresaIgnoreCaseContaining(ruc).forEach(
				(empresa) -> lista.add(empresaConverter.empresaToModel(empresa))
				);
		return lista;
	}

	@Override
	public List<EmpresaModel> findByNomComercial(String nomComercial) {
		List<EmpresaModel> lista = new ArrayList<>();
		empresaRepository.findByNombreComercialIgnoreCaseContaining(nomComercial).forEach(
				(empresa) -> lista.add(empresaConverter.empresaToModel(empresa))
				);
		return lista;
	}

	@Override
	public List<EmpresaModel> findByRSocial(String rSocial) {
		List<EmpresaModel> lista = new ArrayList<>();
		empresaRepository.findByRsEmpresaIgnoreCaseContaining(rSocial).forEach(
				(empresa) -> lista.add(empresaConverter.empresaToModel(empresa))
				);
		return lista;
	}

	@Override
	public EmpresaModel findOneByRuc(String rucEmpresa) {
		Empresa empresa = empresaRepository.findByRucEmpresa(rucEmpresa);
		return empresaConverter.empresaToModel(empresa);
	}

	@Override
	public EmpresaModel findByCodEmpresa(int codEmpresa) {
		Empresa empresa =  empresaRepository.findOne(codEmpresa);
		return empresaConverter.empresaToModel(empresa);
	}

}
