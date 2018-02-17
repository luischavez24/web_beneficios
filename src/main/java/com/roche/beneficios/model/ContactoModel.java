package com.roche.beneficios.model;

import java.util.List;

import com.roche.beneficios.entity.Beneficio;

public class ContactoModel {

	private int idContacto;

	private int codEmpresa;

	private String amContacto;

	private String apContacto;

	private String nomContacto;

	private String telfContacto;

	private List<Beneficio> beneficios;

	private EmpresaModel empresa;

	private String correoElec;
	
	public ContactoModel() {
	}

	public ContactoModel(int idContacto, int codEmpresa, String amContacto, String apContacto, String nomContacto,
			String telfContacto, List<Beneficio> beneficios, EmpresaModel empresa) {
		this.idContacto = idContacto;
		this.codEmpresa = codEmpresa;
		this.amContacto = amContacto;
		this.apContacto = apContacto;
		this.nomContacto = nomContacto;
		this.telfContacto = telfContacto;
		this.beneficios = beneficios;
		this.empresa = empresa;
	}

	public int getIdContacto() {
		return idContacto;
	}

	public void setIdContacto(int idContacto) {
		this.idContacto = idContacto;
	}

	public int getCodEmpresa() {
		return codEmpresa;
	}

	public void setCodEmpresa(int codEmpresa) {
		this.codEmpresa = codEmpresa;
	}

	public String getAmContacto() {
		return amContacto;
	}

	public void setAmContacto(String amContacto) {
		this.amContacto = amContacto;
	}

	public String getApContacto() {
		return apContacto;
	}

	public void setApContacto(String apContacto) {
		this.apContacto = apContacto;
	}

	public String getNomContacto() {
		return nomContacto;
	}

	public void setNomContacto(String nomContacto) {
		this.nomContacto = nomContacto;
	}

	public String getTelfContacto() {
		return telfContacto;
	}

	public void setTelfContacto(String telfContacto) {
		this.telfContacto = telfContacto;
	}

	public List<Beneficio> getBeneficios() {
		return beneficios;
	}

	public void setBeneficios(List<Beneficio> beneficios) {
		this.beneficios = beneficios;
	}

	public EmpresaModel getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaModel empresa) {
		this.empresa = empresa;
	}

	public String getCorreoElec() {
		return correoElec;
	}

	public void setCorreoElec(String correoElec) {
		this.correoElec = correoElec;
	}

	@Override
	public String toString() {
		return String.format("%s %s %s %s", nomContacto, apContacto, amContacto, telfContacto);
	}

}
