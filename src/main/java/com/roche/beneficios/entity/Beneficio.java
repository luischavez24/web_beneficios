package com.roche.beneficios.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the beneficio database table.
 * 
 */
@Entity
@NamedQuery(name="Beneficio.findAll", query="SELECT b FROM Beneficio b")
public class Beneficio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="nro_beneficio")
	private int nroBeneficio;

	@Lob
	private String descripcion;

	@Lob
	@Column(name="detalle_beneficio")
	private String detalleBeneficio;

	@Column(name="img_promo")
	private byte[] imgPromo;
	
	@Column(name="tipo_img_promo")
	private String tipoImgPromo;
	
	@Column(name="descripcion_corta")
	private String descripcionCorta;

	@Column(name="imagen")
	@Lob
	private byte[] imagen;
	
	@Column(name="tipo_imagen")
	private String tipoImagen;

	//bi-directional many-to-one association to Contacto
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="cod_empresa", referencedColumnName="cod_empresa"),
		@JoinColumn(name="id_contacto", referencedColumnName="id_contacto")
		})
	private Contacto contacto;

	//bi-directional many-to-one association to Consideraciones
	@OneToMany(mappedBy="beneficio")
	private List<Consideracion> consideraciones;

	public Beneficio() {
	}

	public int getNroBeneficio() {
		return this.nroBeneficio;
	}

	public void setNroBeneficio(int nroBeneficio) {
		this.nroBeneficio = nroBeneficio;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDetalleBeneficio() {
		return this.detalleBeneficio;
	}

	public void setDetalleBeneficio(String detalleBeneficio) {
		this.detalleBeneficio = detalleBeneficio;
	}

	public byte[] getImgPromo() {
		return this.imgPromo;
	}

	public void setImgPromo(byte[] imgPromo) {
		this.imgPromo = imgPromo;
	}

	public String getDescripcionCorta() {
		return this.descripcionCorta;
	}

	public void setDescripcionCorta(String label) {
		this.descripcionCorta = label;
	}

	public Contacto getContacto() {
		return this.contacto;
	}

	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}

	public List<Consideracion> getConsideraciones() {
		return this.consideraciones;
	}

	public void setConsideraciones(List<Consideracion> consideraciones) {
		this.consideraciones = consideraciones;
	}

	public Consideracion addConsideracione(Consideracion consideracione) {
		getConsideraciones().add(consideracione);
		consideracione.setBeneficio(this);

		return consideracione;
	}

	public Consideracion removeConsideracione(Consideracion consideracione) {
		getConsideraciones().remove(consideracione);
		consideracione.setBeneficio(null);

		return consideracione;
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

	public String getTipoImgPromo() {
		return tipoImgPromo;
	}

	public void setTipoImgPromo(String tipoImgPromo) {
		this.tipoImgPromo = tipoImgPromo;
	}

}