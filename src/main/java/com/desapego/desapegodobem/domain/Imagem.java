package com.desapego.desapegodobem.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Imagem {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idImagem;
	
	private String nome;
	private  byte[] imagem;
	private String email;
	
	public Imagem () {
		
	}
	
	public Imagem(Long id, String nome,  byte[] imagem, String email) {
		super();
		this.idImagem = id;
		this.nome = nome;
		this.imagem = imagem;
		this.email = email;
	}
	
	public Long getIdImagem() {
		return idImagem;
	}

	public void setIdImagem(Long idImagem) {
		this.idImagem = idImagem;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
