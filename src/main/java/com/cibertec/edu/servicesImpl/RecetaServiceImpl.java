package com.cibertec.edu.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.edu.entity.Receta;
import com.cibertec.edu.repository.RecetaRepository;

@Service
public class RecetaServiceImpl implements com.cibertec.edu.services.RecetaService  {
	
	@Autowired
	private RecetaRepository repo;

	@Override
	public List<Receta> listarTodos() {
		return repo.findAll();
	}

	@Override
	public List<Receta> listarFavoritosPorUsuario(Integer cod) {
		return repo.listarRecetasFavoritasPorUsuario(cod);
	}

	
}
