package com.roche.beneficios.model;

import java.util.List;

import com.roche.beneficios.entity.Contacto;
import com.roche.beneficios.entity.Distrito;

public class EmpresaModel {

	private String direccion;

	private String rsEmpresa;
	
	private String nombreComercial;
	
	private String rucEmpresa;

	private String telfEmpresa;
	
	private Distrito distrito;
	
	private List<Contacto> contactos;

	public EmpresaModel() {
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
		return "EmpresaModel [direccion=" + direccion + ", rsEmpresa=" + rsEmpresa + ", nombreComercial="
				+ nombreComercial + ", rucEmpresa=" + rucEmpresa + ", telfEmpresa=" + telfEmpresa + ", contactos="
				+ contactos + "]";
	}
	
	
}
