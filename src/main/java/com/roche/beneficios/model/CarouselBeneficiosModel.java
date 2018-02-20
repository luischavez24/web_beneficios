package com.roche.beneficios.model;

public class CarouselBeneficiosModel {
	
	private int idx;
	
	private byte[] imagen;
	
	private String imagenB64;
	
	private String tipoImagen;
	
	private int nroBeneficio;

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public String getImagenB64() {
		return imagenB64;
	}

	public void setImagenB64(String imagenB64) {
		this.imagenB64 = imagenB64;
	}

	public String getTipoImagen() {
		return tipoImagen;
	}

	public void setTipoImagen(String tipoImagen) {
		this.tipoImagen = tipoImagen;
	}

	public int getNroBeneficio() {
		return nroBeneficio;
	}

	public void setNroBeneficio(int nro_beneficio) {
		this.nroBeneficio = nro_beneficio;
	}
}
