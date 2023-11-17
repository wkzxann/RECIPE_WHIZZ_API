package com.cibertec.edu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cibertec.edu.entity.Receta;

public interface RecetaRepository extends JpaRepository<Receta, Integer> {
	
	@Query(value = "SELECT tb_receta.*\r\n"
			+ "FROM tb_favoritos\r\n"
			+ "INNER JOIN tb_receta ON tb_favoritos.cod_rece = tb_receta.cod_rece\r\n"
			+ "WHERE tb_favoritos.cod_usu = ?1", nativeQuery = true)
	public List<Receta> listarRecetasFavoritasPorUsuario(Integer cod);
	

}
