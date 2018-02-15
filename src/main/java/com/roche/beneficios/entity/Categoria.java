package com.roche.beneficios.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="categorias", uniqueConstraints = @UniqueConstraint(
		columnNames = {"desc_categoria"}))

public class Categoria {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_categoria")
	private int idCategoria;
	
	@Column(name="desc_categoria")
	private String descCategoria;

	@Column(name="icono")
	private String icono;
	
	public Categoria() {
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getDescCategoria() {
		return descCategoria;
	}

	public void setDescCategoria(String descCategoria) {
		this.descCategoria = descCategoria;
	}

	public String getIcono() {
		return icono;
	}

	public void setIcono(String icono) {
		this.icono = icono;
	}
	
}
