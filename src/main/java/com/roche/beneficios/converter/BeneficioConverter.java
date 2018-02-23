package com.roche.beneficios.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.roche.beneficios.entity.Beneficio;
import com.roche.beneficios.entity.Consideracion;
import com.roche.beneficios.model.BeneficioModel;
import com.roche.beneficios.model.ConsideracionModel;
import com.roche.beneficios.utils.ImageConvertor;

@Component("beneficioConverter")
public class BeneficioConverter {
	
	@Autowired
	@Qualifier("contactoConverter")
	private ContactoConverter contactoConverter;
	
	@Autowired
	@Qualifier("consideracionConverter")
	private ConsideracionConverter consideracionConverter;
	
	@Autowired
	@Qualifier("imageConvertor")
	private ImageConvertor imageConvertor;
	
	public Beneficio modelToBeneficio(BeneficioModel entrada) {
		Beneficio salida = new Beneficio();
		List<Consideracion> consideraciones = new ArrayList<>();
		salida.setNroBeneficio(entrada.getNroBeneficio());
		salida.setDescripcion(entrada.getDescripcion());
		salida.setDetalleBeneficio(entrada.getDetalleBeneficio());
		salida.setImgPromo(entrada.getImgPromo());
		salida.setTipoImgPromo(entrada.getTipoImgPromo());
		salida.setDescripcionCorta(entrada.getDescripcionCorta());
		salida.setImagen(entrada.getImagen());
		salida.setTipoImagen(entrada.getTipoImagen());
		salida.setContacto(contactoConverter.modelToContacto(entrada.getContacto()));
		entrada.getConsideraciones().forEach((consideracion) -> {
			consideraciones.add(consideracionConverter.modelToConsideracion(consideracion));
		});
		salida.setConsideraciones(consideraciones);
		salida.setEstado(entrada.getEstado());
		salida.setCategoria(entrada.getCategoria());
		return salida;
	}
	
	public BeneficioModel modelToBeneficio(Beneficio entrada) {
		BeneficioModel salida = new BeneficioModel();
		List<ConsideracionModel> consideraciones = new ArrayList<>();
		salida.setNroBeneficio(entrada.getNroBeneficio());
		salida.setDescripcion(entrada.getDescripcion());
		salida.setDetalleBeneficio(entrada.getDetalleBeneficio());
		salida.setImgPromoB64(imageConvertor.convertToBase64(entrada.getImgPromo()));
		salida.setTipoImgPromo(entrada.getTipoImgPromo());
		salida.setDescripcionCorta(entrada.getDescripcionCorta());
		salida.setImagenB64(imageConvertor.convertToBase64(entrada.getImagen()));
		salida.setTipoImagen(entrada.getTipoImagen());
		salida.setContacto(contactoConverter.contactoToModel(entrada.getContacto()));
		entrada.getConsideraciones().forEach((consideracion) -> {
			consideraciones.add(consideracionConverter.consideracionToModel(consideracion));
		});
		salida.setConsideraciones(consideraciones);
		salida.setEstado(entrada.getEstado());
		salida.setCategoria(entrada.getCategoria());
		
		return salida;
	}
	
	public BeneficioModel modelToBeneficioHeavy(Beneficio entrada) {
		BeneficioModel salida = modelToBeneficio(entrada);
		salida.setImagen(entrada.getImagen());
		salida.setImgPromo(entrada.getImgPromo());
		
		return salida;
	}
	
	public BeneficioModel modelToBeneficioLight(Beneficio entrada) {
		BeneficioModel salida = new BeneficioModel();
		salida.setNroBeneficio(entrada.getNroBeneficio());
		salida.setImgPromoB64(imageConvertor.convertToBase64(entrada.getImgPromo()));
		salida.setTipoImgPromo(entrada.getTipoImgPromo());
		salida.setDescripcionCorta(entrada.getDescripcionCorta());
		salida.setContacto(contactoConverter.contactoToModelLight(entrada.getContacto()));
		salida.setEstado(entrada.getEstado());
		return salida;
	}
	
}
