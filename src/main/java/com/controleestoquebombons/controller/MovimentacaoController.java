package com.controleestoquebombons.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controleestoquebombons.model.Movimentacao;
import com.controleestoquebombons.service.MovimentacaoService;

@RestController
@RequestMapping("/api")
public class MovimentacaoController {
	@Autowired
	private MovimentacaoService movimentacaoService;
	
	@GetMapping(value="/movimentacao/")
	public ResponseEntity<Page<Movimentacao>> findAll(Pageable pageable){
		return ResponseEntity.ok(movimentacaoService.findAll(pageable));
	}
	
	@PostMapping(value="/movimentacao/")
	public Movimentacao addMovimentacao(@RequestBody Movimentacao movimentacao){
		return movimentacaoService.save(movimentacao);
	}
	
	@PutMapping(value="/movimentacao/{id}")
	public Movimentacao updateMovimentacao(@RequestBody Movimentacao movimentacao, @PathVariable long id){
		return movimentacaoService.update(movimentacao);
	}
	
	@DeleteMapping(path="/movimentacao/{id}")
	public ResponseEntity<Void> deleteMovimentacaoById(@PathVariable long id){
		movimentacaoService.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
