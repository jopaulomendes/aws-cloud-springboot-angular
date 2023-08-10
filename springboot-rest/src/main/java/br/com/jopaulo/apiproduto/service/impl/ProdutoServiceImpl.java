package br.com.jopaulo.apiproduto.service.impl;


import java.util.List;

import org.springframework.stereotype.Service;

import br.com.jopaulo.apiproduto.entity.Produto;
import br.com.jopaulo.apiproduto.repository.ProdutoRepository;
import br.com.jopaulo.apiproduto.service.ProdutoService;
import lombok.extern.slf4j.Slf4j;


@Service
public class ProdutoServiceImpl implements ProdutoService {
	
	private final ProdutoRepository produtoRepository;

	public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	@Override
	public List<Produto> buscarTodos() {
		return produtoRepository.findAll();
	}

	@Override
	public Produto salvar(Produto produto) {
		return produtoRepository.save(produto);
	}

	@Override
	public void deletar(Long id) {
		try {
			produtoRepository.deleteById(id);
		} catch (Exception e) {
			throw new RuntimeException("Erro ao exluir o produto");
		}
	}

}
