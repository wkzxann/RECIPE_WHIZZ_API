package com.cibertec.edu.entity;

import java.sql.Date;
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
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_usu")
	private Integer codido;
	@Column(name = "nom_usu")
	private String nombre;
	@Column(name = "ape_usu")
	private String apellido;
	@Column(name = "fec_nac")
	private Date fechaNacimiento;
	@Column(name = "correo")
	private String correo;
	@Column(name = "clave")
	private String clave;
	
	@ManyToMany(mappedBy = "usuario")
	@JsonIgnore
	private List<Favoritos> listaFavoritos;
	
	@ManyToOne
	@JoinColumn(name = "cod_rol")
	private Rol rol;
	
	public List<Favoritos> getListaFavoritos() {
		return listaFavoritos;
	}
	public void setListaFavoritos(List<Favoritos> listaFavoritos) {
		this.listaFavoritos = listaFavoritos;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	public Integer getCodido() {
		return codido;
	}
	public void setCodido(Integer codido) {
		this.codido = codido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	
	

}
