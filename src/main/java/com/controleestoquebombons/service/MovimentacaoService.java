package com.controleestoquebombons.service;

import org.springframework.data.domain.Pageable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.controleestoquebombons.model.Movimentacao;
import com.controleestoquebombons.repository.MovimentacaoRepository;

@Service
public class MovimentacaoService {
	@Autowired
	private MovimentacaoRepository movimentacaoRepository;

	private boolean existsbyId(Long id) {
		return movimentacaoRepository.existsById(id);
	}
	
	public Movimentacao findById(Long id){
		Movimentacao Movimentacao = movimentacaoRepository.findById(id).orElse(null);
		return Movimentacao;
	}
	
	public Page<Movimentacao> findAll(Pageable pageable){
		return movimentacaoRepository.findAll(pageable);
	}
	
	public Movimentacao save(Movimentacao movimentacao){
		return movimentacaoRepository.save(movimentacao);
	}
	
	public Movimentacao update(Movimentacao movimentacao){
	    return movimentacaoRepository.saveAndFlush(movimentacao);
	}
	
	public void deleteById(Long id){
		movimentacaoRepository.deleteById(id);
	}
	
	public Long count() {
		return movimentacaoRepository.count();
	}
}
