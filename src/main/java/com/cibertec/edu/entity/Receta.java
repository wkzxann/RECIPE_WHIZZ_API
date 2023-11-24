package com.cibertec.edu.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_receta")
public class Receta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_rece", nullable = false)
	private Integer codigo;
	@Column(name = "nom_rece", length = 50, nullable = false)
	private String nombre;
	@Column(name = "des_rece", length = 800, nullable = false)
	private String descripcion;
	@Column(name = "tiempo_pre", length = 15, nullable = false)
	private String tiempo;
	@Column(name = "ori_rece", length = 50, nullable = false)
	private String origen;
	@Column(name = "ingredientes", length = 1000, nullable = false)
	private String ingredientes;
	@Column(name = "preparacion", length = 1000, nullable = false)
	private String preparacion;
	@Column(name = "img_rece", length = 100, nullable = false)
	private String imagen;
	
	@OneToMany(mappedBy = "receta")
	@JsonIgnore
	private List<Favoritos> listaFavoritos;
	
	@ManyToOne
	@JoinColumn(name = "cod_cate", nullable = false)
	private Categoria categoria;

	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getTiempo() {
		return tiempo;
	}
	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(String ingredientes) {
		this.ingredientes = ingredientes;
	}
	public String getPreparacion() {
		return preparacion;
	}
	public void setPreparacion(String preparacion) {
		this.preparacion = preparacion;
	}
	public List<Favoritos> getListaFavoritos() {
		return listaFavoritos;
	}
	public void setListaFavoritos(List<Favoritos> listaFavoritos) {
		this.listaFavoritos = listaFavoritos;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	
}
