package com.roche.beneficios.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the consideraciones database table.
 * 
 */
@Embeddable
public class ConsideracionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	
	@Column(name="nro_consideracion")
	private int nroConsideracion;

	@Column(name="nro_beneficio", insertable=false, updatable=false)
	private int nroBeneficio;

	public ConsideracionPK() {
	}
	public int getNroConsideracion() {
		return this.nroConsideracion;
	}
	public void setNroConsideracion(int nroConsideracion) {
		this.nroConsideracion = nroConsideracion;
	}
	public int getNroBeneficio() {
		return this.nroBeneficio;
	}
	public void setNroBeneficio(int nroBeneficio) {
		this.nroBeneficio = nroBeneficio;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ConsideracionPK)) {
			return false;
		}
		ConsideracionPK castOther = (ConsideracionPK)other;
		return 
			(this.nroConsideracion == castOther.nroConsideracion)
			&& (this.nroBeneficio == castOther.nroBeneficio);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.nroConsideracion;
		hash = hash * prime + this.nroBeneficio;
		
		return hash;
	}
	@Override
	public String toString() {
		return "ConsideracionPK [nroConsideracion=" + nroConsideracion + ", nroBeneficio=" + nroBeneficio + "]";
	}
	
}