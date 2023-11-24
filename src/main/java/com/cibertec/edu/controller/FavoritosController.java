package com.cibertec.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cibertec.edu.servicesImpl.FavoritosServiceImpl;

@RestController
@RequestMapping("/favorito")
public class FavoritosController {
	
	@Autowired
	private FavoritosServiceImpl servicioFav;
	
	@PostMapping("/registrar")
	public ResponseEntity<String> agregarFavorito(@RequestParam int usuario, @RequestParam int receta) {
	    try {
	        servicioFav.registrar(usuario, receta);
	        return new ResponseEntity<>("Receta agregada a favoritos exitosamente", HttpStatus.OK);
	    } catch (Exception e) {
	        return new ResponseEntity<>("Error al agregar la receta a favoritos", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
}
