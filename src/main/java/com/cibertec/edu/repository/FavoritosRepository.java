package com.cibertec.edu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cibertec.edu.entity.Favoritos;
import com.cibertec.edu.entity.Receta;

public interface FavoritosRepository extends JpaRepository<Favoritos, Integer> {
	
	

}
