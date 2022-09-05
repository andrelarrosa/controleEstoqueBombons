package controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Movimentacao;
import service.MovimentacaoService;

@RestController
@RequestMapping("/api")
public class MovimentacaoController {
	@Autowired
	private MovimentacaoService movimentacaoService;
	
	@GetMapping(value="/movimentacao/")
	public void findAll(Pageable pageable){
		
	}
	
	@PostMapping(value="/movimentacao/")
	public void addMovimentacao(@RequestBody Movimentacao movimentacao){

	}
	
	@PutMapping(value="/movimentacao/{id}")
	public void updateMovimentacao(@Valid @RequestBody Movimentacao movimentacao, @PathVariable long id){

	}
	
	@DeleteMapping(path="/movimentacao/{id}")
	public void deleteMovimentacaoById(@PathVariable long id){
		
	}
}
