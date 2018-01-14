package com.roche.beneficios.model;

import com.roche.beneficios.entity.Beneficio;

public class ConsideracionModel {
	
	private int nroBeneficio;
	
	private int nroConsideracion;
	
	private String consideración;

	private Beneficio beneficio;

	public ConsideracionModel() {
		
	}
	public ConsideracionModel(String consideración, Beneficio beneficio) {
		this.consideración = consideración;
		this.beneficio = beneficio;
	}

	public int getNroBeneficio() {
		return nroBeneficio;
	}


	public void setNroBeneficio(int nroBeneficio) {
		this.nroBeneficio = nroBeneficio;
	}


	public int getNroConsideracion() {
		return nroConsideracion;
	}


	public void setNroConsideracion(int nroConsideracion) {
		this.nroConsideracion = nroConsideracion;
	}


	public String getConsideración() {
		return consideración;
	}

	public void setConsideración(String consideración) {
		this.consideración = consideración;
	}

	public Beneficio getBeneficio() {
		return beneficio;
	}

	public void setBeneficio(Beneficio beneficio) {
		this.beneficio = beneficio;
	}
}
