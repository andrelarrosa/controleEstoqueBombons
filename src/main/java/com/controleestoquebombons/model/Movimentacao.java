package com.controleestoquebombons.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import lombok.Data;

@Entity
@Table(name = "movimentacao")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Data
public class Movimentacao {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String descricao;
	private String tipo;
	public enum TipoMovimentacao{
		CREDITO, DEBITO
	};
	@Enumerated(EnumType.STRING)
	private TipoMovimentacao tipoMovimentacao;
}
