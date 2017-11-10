package com.roche.beneficios.model;

import java.util.List;

import javax.validation.constraints.*;

import com.roche.beneficios.entity.*;

public class EmpresaModel {
	
	@NotNull
	@Size(min=0, max=1200)
	private int codEmpresa;
	
	private String direccion;

	private String rsEmpresa;
	
	private String nombreComercial;
	
	private String rucEmpresa;

	private String telfEmpresa;
	
	private Distrito distrito;
	
	private List<Contacto> contactos;

	public EmpresaModel() {
	}
	
	public int getCodEmpresa() {
		return codEmpresa;
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

	public String getNombreComercial() {
		return nombreComercial;
	}

	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}
	
	@Override
	public String toString() {
		return "EmpresaModel [codEmpresa=" + codEmpresa + ", direccion=" + direccion + ", rsEmpresa=" + rsEmpresa
				+ ", nombreComercial=" + nombreComercial + ", rucEmpresa=" + rucEmpresa + ", telfEmpresa=" + telfEmpresa
				+ ", distrito=" + distrito + ", contactos=" + contactos + "]";
	}
	
	
}
