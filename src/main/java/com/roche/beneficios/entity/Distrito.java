package com.roche.beneficios.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.roche.beneficios.entity.Empresa;
@Entity
@Table(name="distritos")
@NamedQuery(name="Distrito.findAll", query="SELECT c FROM Distrito c")
public class Distrito {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_distrito")
	private int idDistrito;
	@Column(name="nom_distrito")
	private String nomDistrito;

	@OneToMany(mappedBy="distrito")
	private List<Empresa> empresas;
	
	public Distrito() { }
	
	public Distrito(int idDistrito, String nomDistrito) {
		this.idDistrito = idDistrito;
		this.nomDistrito = nomDistrito;
	}

	public int getIdDistrito() {
		return idDistrito;
	}

	public void setIdDistrito(int idDistrito) {
		this.idDistrito = idDistrito;
	}

	public String getNomDistrito() {
		return nomDistrito;
	}

	public void setNomDistrito(String nomDistrito) {
		this.nomDistrito = nomDistrito;
	}
	
	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}

	@Override
	public String toString() {
		return "Distrito [idDistrito=" + idDistrito + ", nomDistrito=" + nomDistrito + "]";
	}
}
