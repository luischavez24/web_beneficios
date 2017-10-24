package com.roche.beneficios.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the empresas database table.
 * 
 */
@Entity
@Table(name="empresas")
@NamedQuery(name="Empresa.findAll", query="SELECT e FROM Empresa e")
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="cod_empresa")
	private int codEmpresa;

	private String direccion;

	@Column(name="rs_empresa")
	private String rsEmpresa;

	@Column(name="nombre_comercial")
	private String nombreComercial;

	@Column(name="ruc_empresa")
	private String rucEmpresa;

	@Column(name="telf_empresa")
	private String telfEmpresa;
	
	@ManyToOne
	@JoinColumn(name="id_distrito", referencedColumnName="id_distrito", insertable=true, updatable=true)
	private Distrito distrito;
	
	//bi-directional many-to-one association to Contacto
	@OneToMany(mappedBy="empresa")
	private List<Contacto> contactos;

	public Empresa() {
	}

	public int getCodEmpresa() {
		return this.codEmpresa;
	}

	public void setCodEmpresa(int codEmpresa) {
		this.codEmpresa = codEmpresa;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getRsEmpresa() {
		return this.rsEmpresa;
	}

	public void setRsEmpresa(String rsEmpresa) {
		this.rsEmpresa = rsEmpresa;
	}

	public String getRucEmpresa() {
		return this.rucEmpresa;
	}

	public void setRucEmpresa(String rucEmpresa) {
		this.rucEmpresa = rucEmpresa;
	}

	public String getTelfEmpresa() {
		return this.telfEmpresa;
	}

	public void setTelfEmpresa(String telfEmpresa) {
		this.telfEmpresa = telfEmpresa;
	}

	public List<Contacto> getContactos() {
		return this.contactos;
	}

	public void setContactos(List<Contacto> contactos) {
		this.contactos = contactos;
	}

	public Contacto addContacto(Contacto contacto) {
		getContactos().add(contacto);
		contacto.setEmpresa(this);

		return contacto;
	}

	public String getNombreComercial() {
		return nombreComercial;
	}

	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}

	public Contacto removeContacto(Contacto contacto) {
		getContactos().remove(contacto);
		contacto.setEmpresa(null);

		return contacto;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	@Override
	public String toString() {
		return "Empresa [codEmpresa=" + codEmpresa + ", direccion=" + direccion + ", rsEmpresa=" + rsEmpresa
				+ ", nombreComercial=" + nombreComercial + ", rucEmpresa=" + rucEmpresa + ", telfEmpresa=" + telfEmpresa
				+ ", distrito=" + distrito + ", contactos=" + contactos + "]";
	}
	
	
	

}