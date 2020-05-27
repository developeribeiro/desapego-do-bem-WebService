package com.desapego.desapegodobem.domain;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
	
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Optional<Usuario> getUsuarioById(Long id) {
		return usuarioRepository.findById(id);
	}
	

}
