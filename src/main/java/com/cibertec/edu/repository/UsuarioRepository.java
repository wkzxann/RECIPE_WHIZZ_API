package com.cibertec.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.edu.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	Usuario findByCorreoAndClave(String correo, String clave);
	Usuario findByCorreo(String correo);

}
