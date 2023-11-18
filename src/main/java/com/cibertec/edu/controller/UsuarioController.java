package com.cibertec.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cibertec.edu.entity.Usuario;
import com.cibertec.edu.servicesImpl.UsuarioServiceImpl;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioServiceImpl servicioUsuario;
	
	@GetMapping()
	public ResponseEntity<List<Usuario>> lista() {
		return new ResponseEntity<>(servicioUsuario.listarTodos(), HttpStatus.OK);
	}
	
	@PostMapping("/{correo},{clave}")
	public ResponseEntity<?> buscar(@PathVariable("correo") String correo,
	                                @PathVariable("clave") String clave) {
	    Usuario usuario = servicioUsuario.buscarUsuario(correo, clave);

	    if (usuario != null) {
	        return new ResponseEntity<>(usuario, HttpStatus.OK);
	    } else {
	        String mensajeError = "Usuario no encontrado";
	        return new ResponseEntity<>(mensajeError, HttpStatus.NOT_FOUND);
	    }
	}
	
	@PostMapping("/register")
    public ResponseEntity<?> registrar(@RequestBody Usuario bean) {
        try {
            Usuario obj = servicioUsuario.registrar(bean);
            return new ResponseEntity<>(obj, HttpStatus.CREATED);
        } catch (DuplicateKeyException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al registrar el usuario.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
