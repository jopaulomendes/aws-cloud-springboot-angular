package br.com.jopaulo.apiproduto.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jopaulo.apiproduto.entity.Produto;
import br.com.jopaulo.apiproduto.service.ProdutoService;


@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

	private final ProdutoService produtoService;
	
	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}
	
	@GetMapping
	public ResponseEntity<List<Produto>> buscarTodos(){
		return ResponseEntity.ok(produtoService.buscarTodos());
	}
	
	@PostMapping
	public ResponseEntity<Produto> salvar(@RequestBody Produto produto){
		var novoProduto = produtoService.salvar(produto);
		return new ResponseEntity<>(novoProduto, null, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id){
		produtoService.deletar(id);
		return ResponseEntity.ok().build();
	}
}
