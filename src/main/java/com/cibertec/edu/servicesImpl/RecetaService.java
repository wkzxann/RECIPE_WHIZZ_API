package com.cibertec.edu.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.cibertec.edu.entity.Receta;
import com.cibertec.edu.repository.RecetaRepository;

@Service
public class RecetaService extends ICRUDImpl<Receta, Integer> {
	
	@Autowired
	private RecetaRepository repo;

	@Override
	public JpaRepository<Receta, Integer> getRepository() {
		return repo;
	}
}
