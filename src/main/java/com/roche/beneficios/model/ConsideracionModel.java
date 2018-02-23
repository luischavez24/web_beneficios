package com.roche.beneficios.model;

public class ConsideracionModel {
	
	private int nroBeneficio;
	
	private int nroConsideracion;
	
	private String consideracion;

	public ConsideracionModel() {
		
	}
	
	public ConsideracionModel(String consideracion) {
		this.consideracion = consideracion;
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

	public String getConsideracion() {
		return consideracion;
	}

	public void setConsideracion(String consideracion) {
		this.consideracion = consideracion;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("{id: {nroBeneficio: %d, nroConsideracion: %d}, consideracion: %s}", nroBeneficio, nroConsideracion,consideracion);
	}
}
