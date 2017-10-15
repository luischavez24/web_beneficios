package com.roche.beneficios.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the contacto database table.
 * 
 */
@Entity
@NamedQuery(name="Contacto.findAll", query="SELECT c FROM Contacto c")
public class Contacto implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ContactoPK id;

	@Column(name="am_contacto")
	private String amContacto;

	@Column(name="ap_contacto")
	private String apContacto;

	@Column(name="nom_contacto")
	private String nomContacto;

	@Column(name="telf_contacto")
	private String telfContacto;

	//bi-directional many-to-one association to Beneficio
	@OneToMany(mappedBy="contacto")
	private List<Beneficio> beneficios;

	//bi-directional many-to-one association to Empresa
	@ManyToOne
	@JoinColumn(name="cod_empresa", referencedColumnName="cod_empresa", insertable=false, updatable=false)
	private Empresa empresa;
		
	public Contacto() {
	}

	public ContactoPK getId() {
		return this.id;
	}

	public void setId(ContactoPK id) {
		this.id = id;
	}

	public String getAmContacto() {
		return this.amContacto;
	}

	public void setAmContacto(String amContacto) {
		this.amContacto = amContacto;
	}

	public String getApContacto() {
		return this.apContacto;
	}

	public void setApContacto(String apContacto) {
		this.apContacto = apContacto;
	}

	public String getNomContacto() {
		return this.nomContacto;
	}

	public void setNomContacto(String nomContacto) {
		this.nomContacto = nomContacto;
	}

	public String getTelfContacto() {
		return this.telfContacto;
	}

	public void setTelfContacto(String telfContacto) {
		this.telfContacto = telfContacto;
	}

	public List<Beneficio> getBeneficios() {
		return this.beneficios;
	}

	public void setBeneficios(List<Beneficio> beneficios) {
		this.beneficios = beneficios;
	}

	public Beneficio addBeneficio(Beneficio beneficio) {
		getBeneficios().add(beneficio);
		beneficio.setContacto(this);

		return beneficio;
	}

	public Beneficio removeBeneficio(Beneficio beneficio) {
		getBeneficios().remove(beneficio);
		beneficio.setContacto(null);

		return beneficio;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}