package com.roche.beneficios.model;

import com.roche.beneficios.entity.Beneficio;

public class ConsideracionModel {
	
	private String consideración;

	private Beneficio beneficio;

	public ConsideracionModel(String consideración, Beneficio beneficio) {
		this.consideración = consideración;
		this.beneficio = beneficio;
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
