package com.controleestoquebombons.repository;

import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.controleestoquebombons.model.Movimentacao;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {
	
	@Query(value = "select a from Movimentacao a where a.descricao like %?1%")
	Page<Movimentacao> findByNome(String descricao, Pageable page);
	
	Page<Movimentacao> findAll(Pageable page);
}