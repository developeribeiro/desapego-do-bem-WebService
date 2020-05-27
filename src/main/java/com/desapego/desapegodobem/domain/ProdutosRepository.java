package com.desapego.desapegodobem.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ProdutosRepository extends CrudRepository<Produtos, Long> {

	List<Produtos> findByNome(String nome);


}
