package com.controleestoquebombons.repository;

import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.controleestoquebombons.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	@Query(value = "select a from Cliente a where a.nome like %?1%")
	Page<Cliente> findByNome(String nome, Pageable page);
	
	Page<Cliente> findAll(Pageable page);
}