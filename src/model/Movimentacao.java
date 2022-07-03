package model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="movimentacao")
@Getter
@Setter
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
