package com.cibertec.edu.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.cibertec.edu.entity.Rol;
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

	@Override
	public Usuario registrar(Usuario usuario) {
		validarDuplicados(usuario);
		Rol r = new Rol();
        r.setCodigoRol(2);
        usuario.setRol(r);
        return repo.save(usuario);
	}
	
	@Override
	public Usuario actualizar(Usuario usuario) {
		return repo.save(usuario);
	}
	
	private void validarDuplicados(Usuario usuario) {
        if (repo.existsByCorreo(usuario.getCorreo())) {
            throw new DuplicateKeyException("El correo electrónico ya está registrado");
        }
	}

	

}
