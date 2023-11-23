package com.cibertec.edu.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.edu.entity.Favoritos;
import com.cibertec.edu.entity.Receta;
import com.cibertec.edu.entity.Usuario;
import com.cibertec.edu.repository.FavoritosRepository;
import com.cibertec.edu.services.FavoritosService;

@Service
public class FavoritosServiceImpl implements FavoritosService {
	
	@Autowired
	private FavoritosRepository repo;
	
	@Override
	public void registrar(int usuarioId, int recetaId) {
		
		Favoritos favoritos = new Favoritos();
		Usuario u = new Usuario();
		u.setCodido(usuarioId);
        favoritos.setUsuario(u);
        Receta r = new Receta();
        r.setCodigo(recetaId);
        favoritos.setReceta(r);

        repo.save(favoritos);
		
	}

}
