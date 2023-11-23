package com.cibertec.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cibertec.edu.entity.Receta;
import com.cibertec.edu.entity.Usuario;
import com.cibertec.edu.servicesImpl.RecetaServiceImpl;
import com.cibertec.edu.utils.NotFoundException;

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
	
	@PostMapping("/register")
    public ResponseEntity<?> registrar(@RequestBody Receta receta) {
        try {
            servicioReceta.registrar(receta);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DuplicateKeyException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al registrar el usuario.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	@PutMapping("/actualizar")
	public ResponseEntity<Receta> actualizar(@RequestBody Receta bean) {
		Receta emp = servicioReceta.BuscarPorId(bean.getCodigo());
		if (emp == null)
			throw new NotFoundException();
		else
			emp = servicioReceta.actualizar(bean);
		
		return new ResponseEntity<>(emp,HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{codigo}")
	public ResponseEntity<Void> eliminar(@PathVariable("codigo") Integer cod){
		//buscar còdigo
		Receta emp = servicioReceta.BuscarPorId(cod);
		//validar
		if(emp == null)
			throw new NotFoundException();
		else
			servicioReceta.eliminar(cod);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}