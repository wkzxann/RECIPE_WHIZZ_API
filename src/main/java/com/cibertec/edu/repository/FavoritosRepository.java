package com.cibertec.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cibertec.edu.entity.Favoritos;

public interface FavoritosRepository extends JpaRepository<Favoritos, Integer> {

}
