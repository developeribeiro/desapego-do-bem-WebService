package com.desapego.desapegodobem.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.desapego.desapegodobem.domain.ProdutoService;
import com.desapego.desapegodobem.domain.Produtos;

@RestController
@RequestMapping("api/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService; 
	
	
	@GetMapping
	public ResponseEntity <Iterable<Produtos>> get() {
		return ResponseEntity.ok(produtoService.getAllProdutos()); 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity getbyId(@PathVariable("id") Long id) {
		Optional<Produtos> produtos = produtoService.getProdutosById(id);
		return produtos
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity getByNome(@PathVariable("nome")String nome) {
		List<Produtos> produtos = produtoService.getProdutosByNome(nome);
		return produtos.isEmpty() ?
				ResponseEntity.noContent().build() :
				ResponseEntity.ok(produtos);	
	}
	
	@PostMapping()
	public String salvaProduto(@RequestBody Produtos produto) {
		Produtos p = produtoService.save(produto);
		
		return "Produto salvo com sucesso  " + p.getId();
	}
	
	@PutMapping("/{id}")
	public String atualizaProduto(@PathVariable("id")Long id, @RequestBody Produtos produto) {
		
		Produtos p = produtoService.update(produto, id);
		
		return "Produto Atualizado com sucesso  " + p.getId();
		
	}
	
	@DeleteMapping("/{id}")
	public String deletaProduto(@PathVariable("id") Long id ) {
		produtoService.delete(id);
		
		return "Produto deletado com sucesso";
	}
	
}
