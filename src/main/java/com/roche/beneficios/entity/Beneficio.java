package com.roche.beneficios.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

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
	
	@Column(name="descripcion_corta", length=25)
	private String descripcionCorta;
	
	@Column(name="descripcion", length = 120)
	private String descripcion;
	
	@Column(name="detalle_beneficio")
	private String detalleBeneficio;

	@Column(name="img_promo")
	@Lob
	private byte[] imgPromo;
	
	@Column(name="tipo_img_promo", length = 25)
	private String tipoImgPromo;
	
	@Column(name="imagen")
	@Lob
	private byte[] imagen;
	
	@Column(name="tipo_imagen", length = 25)
	private String tipoImagen;
	
	@Column(name="estado")
	private boolean estado;

	
	//bi-directional many-to-one association to Contacto
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="cod_empresa", referencedColumnName="cod_empresa"),
		@JoinColumn(name="id_contacto", referencedColumnName="id_contacto")
		})
	private Contacto contacto;
	
	@ManyToOne
	@JoinColumn(name="id_categoria", referencedColumnName="id_categoria", insertable=true, updatable=true)
	private Categoria categoria;

	//bi-directional many-to-one association to Consideraciones
	@OneToMany(mappedBy="beneficio")
	@NotFound(action = NotFoundAction.IGNORE)
	private List<Consideracion> consideraciones;
	
	@OneToOne(mappedBy="beneficio")
	private CarouselBeneficios carouselBeneficios;
	
	public Beneficio() { }

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

	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public CarouselBeneficios getCarouselBeneficios() {
		return carouselBeneficios;
	}

	public void setCarouselBeneficios(CarouselBeneficios carouselBeneficios) {
		this.carouselBeneficios = carouselBeneficios;
	}
}