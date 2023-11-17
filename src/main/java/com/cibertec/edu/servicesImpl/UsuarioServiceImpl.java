package com.cibertec.edu.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.edu.entity.Usuario;
import com.cibertec.edu.repository.UsuarioRepository;
import com.cibertec.edu.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository repo;

	@Override
	public List<Usuario> listarTodos() {
		return repo.findAll();
	}

	@Override
	public Usuario buscarUsuario(String correo, String clave) {
		return repo.findByCorreoAndClave(correo, clave);
	}

	@Override
	public Usuario buscarPorID(Integer cod) {
		return repo.findById(cod).orElse(null);
	}

	@Override
	public Usuario buscarPorCorreo(String correo) {
		return repo.findByCorreo(correo);
	}

}
