package com.cibertec.edu.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_receta")
public class Receta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_rece")
	private Integer codigo;
	@Column(name = "nom_rece")
	private String nombre;
	@Column(name = "des_rece")
	private String descripcion;
	@Column(name = "preparacion_rece")
	private String preparacion;
	@Column(name = "ori_rece")
	private String origen;
	
	
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
	public String getPreparacion() {
		return preparacion;
	}
	public void setPreparacion(String preparacion) {
		this.preparacion = preparacion;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}

	
	
}
