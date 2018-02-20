package com.roche.beneficios.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "carousel_beneficios", uniqueConstraints = @UniqueConstraint(
		columnNames = {"nro_beneficio"}))
public class CarouselBeneficios {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name="idx")
	private int idx;
	
	@Column(name = "imagen")
	@Lob
	private byte[] imagen;
	
	@Column(name = "tipo_imagen", length = 25)
	private String tipoImagen;
	
	@OneToOne
	@JoinColumn(name="nro_beneficio", referencedColumnName="nro_beneficio")
	private Beneficio beneficio;

	public CarouselBeneficios() {
		
	}
	
	public int getIdx() {
		return idx;
	}

	public void setIdx(int index) {
		this.idx = index;
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

	public Beneficio getBeneficio() {
		return beneficio;
	}

	public void setBeneficio(Beneficio beneficio) {
		this.beneficio = beneficio;
	}
}
