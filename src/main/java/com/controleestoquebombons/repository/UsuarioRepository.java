package com.controleestoquebombons.repository;

import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.controleestoquebombons.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	@Query(value = "select a from Usuario a where a.nome like %?1%")
	Page<Usuario> findByNome(String nome, Pageable page);
	
	Page<Usuario> findAll(Pageable page);

}