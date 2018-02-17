package com.roche.beneficios.model;

import java.util.List;

import com.roche.beneficios.entity.Categoria;
import com.roche.beneficios.model.ContactoModel;

public class BeneficioModel {
	
	private int nroBeneficio;
	
	private String descripcion;

	private String detalleBeneficio;

	private String descripcionCorta;

	private byte[] imagen;
	
	private String imagenB64;
	
	private String tipoImagen;
	
	private byte[] imgPromo;
	
	private String imgPromoB64;
	
	private String tipoImgPromo;

	private ContactoModel contacto;

	private List<ConsideracionModel> consideraciones;
	
	private int estado;
	
	private Categoria categoria;
	
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

	public int getEstado() {
		return estado;
	}


	public void setEstado(int estado) {
		this.estado = estado;
	}


	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getImagenB64() {
		return imagenB64;
	}

	public void setImagenB64(String imagenB64) {
		this.imagenB64 = imagenB64;
	}

	public String getImgPromoB64() {
		return imgPromoB64;
	}

	public void setImgPromoB64(String imgPromoB64) {
		this.imgPromoB64 = imgPromoB64;
	}

	@Override
	public String toString() {
		return "BeneficioModel [nroBeneficio=" + nroBeneficio + ", descripcion=" + descripcion + ", detalleBeneficio="
				+ detalleBeneficio + ", descripcionCorta=" + descripcionCorta + ", estado=" + estado 
				+ ", consideraciones=" + consideraciones + ", contacto=" + contacto +  "]";
	}
	
	
}
