package com.cibertec.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cibertec.edu.entity.Receta;

public interface RecetaRepository extends JpaRepository<Receta, Integer> {

}
