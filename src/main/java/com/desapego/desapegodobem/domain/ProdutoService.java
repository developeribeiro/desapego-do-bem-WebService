package com.desapego.desapegodobem.domain;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutosRepository produtosRepository;

	public Iterable<Produtos> getAllProdutos() {
		return produtosRepository.findAll();
	}
	
	
	public Optional<Produtos> getProdutosById(Long id) {
		return produtosRepository.findById(id);
	}
	

	public List<Produtos> getProdutosByNome(String nome) {
		
		return produtosRepository.findByNome(nome);
	}
	
	public Produtos save(Produtos produto) {
		return produtosRepository.save(produto);
		
	}

	public Produtos update(Produtos produto, Long id) {
		Assert.notNull(id,"Não foi possível atualizar o registro");
		
		Optional<Produtos> optional = getProdutosById(id);
		if(optional.isPresent()) {
			Produtos db = optional.get();
			db.setNome(produto.getNome());
			db.setDescricao(produto.getDescricao());
			System.out.println("Produto id" + db.getId());
			
			produtosRepository.save(db);
			
			return db;
		}else {
			throw new RuntimeErrorException(null,"Não foi possível atualizar o registro");
		}
	}

	public void delete(Long id) {
		Optional<Produtos> produtos = getProdutosById(id);
		if(produtos.isPresent()) {
			produtosRepository.deleteById(id);
		}
		
	}
	
}
