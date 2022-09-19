package com.controleestoquebombons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.controleestoquebombons.model.Cliente;
import com.controleestoquebombons.repository.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;
	
	private boolean existsbyId(Long id) {
		return clienteRepository.existsById(id);
	}
	
	public Cliente findById(Long id){
		Cliente cliente = clienteRepository.findById(id).orElse(null);
		return cliente;
	}
	
	public Page<Cliente> findAll(Pageable pageable){
		return clienteRepository.findAll(pageable);
	}
	
	public Cliente save(Cliente cliente){
		return clienteRepository.save(cliente);
	}
	
	public Cliente update(Cliente cliente){
	    return clienteRepository.save(cliente);
	}
	
	public void deleteById(Long id){
		clienteRepository.deleteById(id);
	}
	
	public Long count() {
		return clienteRepository.count();
	}
}
