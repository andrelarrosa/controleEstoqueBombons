package controller;

import java.net.URI;
import java.net.URISyntaxException;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import exception.BadResourceException;
import exception.ResourceAlreadyExistsException;
import service.ClienteService;

import model.Cliente;

@RestController
@RequestMapping("/api")
public class ClienteController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping(value="/cliente")
	public ResponseEntity<Page<Cliente>> findAll(Pageable pageable){
		return ResponseEntity.ok(clienteService.findAll(pageable));
	}
	
	@PostMapping(value="/cliente")
	public ResponseEntity<Cliente> addCliente(@RequestBody Cliente cliente) throws URISyntaxException{
		try {
			Cliente c = clienteService.save(cliente);
			return ResponseEntity.created(new URI("/api/categoria/"+c.getId())).body(cliente);
		}catch(ResourceAlreadyExistsException ex) {
			logger.error(ex.getMessage());
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}catch(BadResourceException ex) {
			logger.error(ex.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

	}
	
	@PutMapping(value="/cliente/{id}")
	public void updateCliente(@Valid @RequestBody Cliente cliente, @PathVariable long id){

	}
	
	@DeleteMapping(path="/cliente/{id}")
	public void deleteClienteById(@PathVariable long id){
		
	}

}
