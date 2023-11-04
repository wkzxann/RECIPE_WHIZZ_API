package com.cibertec.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cibertec.edu.entity.Receta;
import com.cibertec.edu.servicesImpl.RecetaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/receta")
public class RecetaController {
	@Autowired
	private RecetaService servicioViaje;
	
	@GetMapping("/lista")
	public ResponseEntity<List<Receta>> lista( ){
		return  new ResponseEntity<>(servicioViaje.listarTodos(),HttpStatus.OK);
	}
	
	
	
}












