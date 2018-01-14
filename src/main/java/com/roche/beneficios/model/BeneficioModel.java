package com.roche.beneficios.model;

import java.util.List;

import com.roche.beneficios.model.ContactoModel;

public class BeneficioModel {
	
	private int nroBeneficio;
	
	private String descripcion;

	private String detalleBeneficio;


	private String descripcionCorta;

	private byte[] imagen;
	
	private String tipoImagen;
	
	private byte[] imgPromo;
	
	private String tipoImgPromo;

	private ContactoModel contacto;

	private List<ConsideracionModel> consideraciones;

	public BeneficioModel() {
		
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

	public byte[] getImgPromo() {
		return imgPromo;
	}

	public void setImgPromo(byte[] imgPromo) {
		this.imgPromo = imgPromo;
	}

	public ContactoModel getContacto() {
		return contacto;
	}

	public void setContacto(ContactoModel contacto) {
		this.contacto = contacto;
	}

	public List<ConsideracionModel> getConsideraciones() {
		return consideraciones;
	}

	public void setConsideraciones(List<ConsideracionModel> consideraciones) {
		this.consideraciones = consideraciones;
	}


	public String getDescripcionCorta() {
		return descripcionCorta;
	}


	public void setDescripcionCorta(String descripcionCorta) {
		this.descripcionCorta = descripcionCorta;
	}


	public byte[] getImagen() {
		return imagen;
	}


	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}


	public String getTipoImagen() {
		return tipoImagen;
	}


	public void setTipoImagen(String tipoImagen) {
		this.tipoImagen = tipoImagen;
	}


	public String getTipoImgPromo() {
		return tipoImgPromo;
	}


	public void setTipoImgPromo(String tipoImgPromo) {
		this.tipoImgPromo = tipoImgPromo;
	}


	public int getNroBeneficio() {
		return nroBeneficio;
	}


	public void setNroBeneficio(int nroBeneficio) {
		this.nroBeneficio = nroBeneficio;
	}
	
	
}
