package com.desapego.desapegodobem.domain;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImagemService {

	
	@Autowired
	private ImagemRepository imagemRepository ;

	public Iterable<Imagem> getAllImagens() {
		return imagemRepository.findAll();
	}
	
	
	public Optional<Imagem> getImagensById(Long id) {
		return imagemRepository.findById(id);
	}
	
	
	
}
