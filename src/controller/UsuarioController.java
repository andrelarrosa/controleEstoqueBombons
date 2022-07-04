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

import model.Usuario;
import service.UsuarioService;

@RestController
@RequestMapping("/api")
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping(value="/usuario")
	public void findAll(Pageable pageable){
		
	}
	
	@PostMapping(value="/usuario")
	public void addUsuario(@RequestBody Usuario usuario){

	}
	
	@PutMapping(value="/usuario/{id}")
	public void updateUsuario(@Valid @RequestBody Usuario usuario, @PathVariable long id){

	}
	
	@DeleteMapping(path="/usuario/{id}")
	public void deleteUsuarioById(@PathVariable long id){
		
	}

}
