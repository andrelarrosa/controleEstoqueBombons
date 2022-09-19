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

import com.controleestoquebombons.model.Cliente;
import com.controleestoquebombons.service.ClienteService;

@RestController
@RequestMapping("/api")
public class ClienteController {
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping(value="/cliente/")
	public ResponseEntity<Page<Cliente>> findAll(Pageable pageable){
		return ResponseEntity.ok(clienteService.findAll(pageable));
	}
	
	@PostMapping(value="/cliente/")
	public Cliente addCliente(@RequestBody Cliente cliente) {
		return clienteService.save(cliente);
	}
	
	@PutMapping(value="/cliente/{id}")
	public Cliente updateCliente(@RequestBody Cliente cliente, @PathVariable long id){
		return clienteService.update(cliente);
	}
	
	@DeleteMapping(path="/cliente/{id}")
	public ResponseEntity<Void> deleteClienteById(@PathVariable long id){
		clienteService.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
