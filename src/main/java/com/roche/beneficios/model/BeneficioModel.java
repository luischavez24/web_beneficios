package com.roche.beneficios.model;

import java.util.List;

import com.roche.beneficios.entity.Contacto;

public class BeneficioModel {
	
	private String descripcion;

	private String detalleBeneficio;

	private String imgPromo;

	private String label;

	private String ubicacion;

	private Contacto contacto;

	private List<ConsideracionModel> consideraciones;

	public BeneficioModel( String descripcion, String detalleBeneficio, String imgPromo, String label,
			String ubicacion, Contacto contacto) {
		this.descripcion = descripcion;
		this.detalleBeneficio = detalleBeneficio;
		this.imgPromo = imgPromo;
		this.label = label;
		this.ubicacion = ubicacion;
		this.contacto = contacto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDetalleBeneficio() {
		return detalleBeneficio;
	}

	public void setDetalleBeneficio(String detalleBeneficio) {
		this.detalleBeneficio = detalleBeneficio;
	}

	public String getImgPromo() {
		return imgPromo;
	}

	public void setImgPromo(String imgPromo) {
		this.imgPromo = imgPromo;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Contacto getContacto() {
		return contacto;
	}

	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}

	public List<ConsideracionModel> getConsideraciones() {
		return consideraciones;
	}

	public void setConsideraciones(List<ConsideracionModel> consideraciones) {
		this.consideraciones = consideraciones;
	}

}
