package com.cibertec.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.edu.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	public Usuario findByCorreoAndClave(String correo, String clave);
	public Usuario findByCorreo(String correo);
	public boolean existsByCorreo(String correo);

}
