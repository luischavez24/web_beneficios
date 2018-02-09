package com.roche.beneficios.model;

public class ConsideracionModel {
	
	private int nroBeneficio;
	
	private int nroConsideracion;
	
	private String consideración;

	public ConsideracionModel() {
		
	}
	
	public ConsideracionModel(String consideración) {
		this.consideración = consideración;
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

}
