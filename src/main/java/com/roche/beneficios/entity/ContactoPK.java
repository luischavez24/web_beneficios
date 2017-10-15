package com.roche.beneficios.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the contacto database table.
 * 
 */
@Embeddable
public class ContactoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_contacto")
	private int idContacto;

	@Column(name="cod_empresa", insertable=false, updatable=false)
	private int codEmpresa;

	public ContactoPK() {
	}
	public int getIdContacto() {
		return this.idContacto;
	}
	public void setIdContacto(int idContacto) {
		this.idContacto = idContacto;
	}
	public int getCodEmpresa() {
		return this.codEmpresa;
	}
	public void setCodEmpresa(int codEmpresa) {
		this.codEmpresa = codEmpresa;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ContactoPK)) {
			return false;
		}
		ContactoPK castOther = (ContactoPK)other;
		return 
			(this.idContacto == castOther.idContacto)
			&& (this.codEmpresa == castOther.codEmpresa);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idContacto;
		hash = hash * prime + this.codEmpresa;
		
		return hash;
	}
}