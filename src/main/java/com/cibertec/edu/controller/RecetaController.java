package com.cibertec.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cibertec.edu.entity.Receta;
import com.cibertec.edu.servicesImpl.RecetaServiceImpl;

@RestController
@RequestMapping("/recetas")
public class RecetaController {
	@Autowired
	private RecetaServiceImpl servicioReceta;
	
	@GetMapping
	public ResponseEntity<List<Receta>> lista() {
	    List<Receta> recetas = servicioReceta.listarTodos();
	    return new ResponseEntity<>(recetas, HttpStatus.OK);
	}
	
	@GetMapping("/favoritos/{cod}")
	public ResponseEntity<List<Receta>> obtenerRecetasFavoritasPorUsuario(@PathVariable("cod") Integer codigoUsuario) {
		
	    List<Receta> recetasFavoritas = servicioReceta.listarFavoritosPorUsuario(codigoUsuario);

	    if (recetasFavoritas.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    } else {
	        return new ResponseEntity<>(recetasFavoritas, HttpStatus.OK);
	    }
	}

}