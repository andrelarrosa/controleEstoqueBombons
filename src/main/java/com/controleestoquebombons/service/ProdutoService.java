package com.controleestoquebombons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.controleestoquebombons.model.Produto;
import com.controleestoquebombons.repository.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository produtoRepository;
	
	private boolean existsbyId(Long id) {
		return produtoRepository.existsById(id);
	}
	
	public Produto findById(Long id){
		Produto produto = produtoRepository.findById(id).orElse(null);
		return produto;
	}
	
	public Page<Produto> findAll(Pageable pageable){
		return produtoRepository.findAll(pageable);
	}
	
	public Produto save(Produto produto){
		return produtoRepository.save(produto);
	}
	
	public Produto update(Produto produto){
	    return produtoRepository.saveAndFlush(produto);
	}
	
	public void deleteById(Long id){
		produtoRepository.deleteById(id);
	}
	
	public Long count() {
		return produtoRepository.count();
	}
}
