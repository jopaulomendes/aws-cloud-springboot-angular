package br.com.jopaulo.apiproduto.service;

import java.util.List;

import br.com.jopaulo.apiproduto.entity.Produto;

public interface ProdutoService {
	List<Produto> buscarTodos();
	Produto salvar(Produto produto);
	void deletar(Long id);
}
