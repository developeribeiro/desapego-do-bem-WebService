package com.desapego.desapegodobem.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desapego.desapegodobem.domain.Imagem;
import com.desapego.desapegodobem.domain.ImagemService;

@RestController
@RequestMapping("api/imagem")
public class ImagemController {

	@Autowired
	private ImagemService imagemService; 
	
	@GetMapping
	public Iterable<Imagem> get() {
		return imagemService.getAllImagens();
	}
	
	@GetMapping("/{id}")
	public Optional<Imagem> getbyId(@PathVariable("id") Long id) {
		return imagemService.getImagensById(id);
	}
	
	
}
