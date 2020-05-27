package com.desapego.desapegodobem.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desapego.desapegodobem.domain.Usuario;
import com.desapego.desapegodobem.domain.UsuarioService;

@RestController
@RequestMapping("api/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	
	@GetMapping("/{id}")
	public ResponseEntity getbyId(@PathVariable("id") Long id) {
		Optional<Usuario> produtos = usuarioService.getUsuarioById(id);
		return produtos
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	
}
