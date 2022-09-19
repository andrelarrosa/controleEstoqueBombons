package com.controleestoquebombons.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import lombok.Data;

@Entity
@Table(name = "movimentacao_produto")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Data
public class MovimentacaoProduto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private int movimentacao;
	@ManyToOne
	@JoinColumn(name = "produto")
	private Produto produto;
	@ManyToOne
	@JoinColumn(name = "cliente")
	private Cliente cliente;
}
