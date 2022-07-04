package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import model.Movimentacao;
import repository.MovimentacaoRepository;

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
	    return movimentacaoRepository.save(movimentacao);
	}
	
	public void deleteById(Long id){
		movimentacaoRepository.deleteById(id);
	}
	
	public Long count() {
		return movimentacaoRepository.count();
	}
}
