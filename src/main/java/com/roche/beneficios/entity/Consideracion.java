package com.roche.beneficios.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the consideraciones database table.
 * 
 */
@Entity
@Table(name="consideraciones")
@NamedQuery(name="Consideracion.findAll", query="SELECT c FROM Consideracion c")
public class Consideracion implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ConsideracionPK id;
	
	@Column(name="consideracion")
	private String consideracion;

	//bi-directional many-to-one association to Beneficio
	@ManyToOne
	@JoinColumn(name="nro_beneficio", referencedColumnName="nro_beneficio", insertable=false, updatable=false)
	private Beneficio beneficio;

	public Consideracion() {
	}

	public ConsideracionPK getId() {
		return this.id;
	}

	public void setId(ConsideracionPK id) {
		this.id = id;
	}

	public String getConsideracion() {
		return this.consideracion;
	}

	public void setConsideracion(String consideracion) {
		this.consideracion = consideracion;
	}

	public Beneficio getBeneficio() {
		return this.beneficio;
	}

	public void setBeneficio(Beneficio beneficio) {
		this.beneficio = beneficio;
	}

}