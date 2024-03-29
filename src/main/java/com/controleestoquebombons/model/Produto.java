package com.controleestoquebombons.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


import lombok.Data;

@Entity
@Table(name="produto")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Data
public class Produto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String descricao;
	private int qtdeEstoque;
	private double preco;
}
