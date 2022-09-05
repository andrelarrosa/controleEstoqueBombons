package controller;

import javax.validation.Valid;

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

import model.Usuario;
import service.UsuarioService;

@RestController
@RequestMapping("/api")
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping(value="/usuario/")
	public ResponseEntity<Page<Usuario>> findAll(Pageable pageable){
		return ResponseEntity.ok(usuarioService.findAll(pageable));
	}
	
	@PostMapping(value="/usuario/")
	public Usuario addUsuario(@RequestBody Usuario usuario){
		return usuarioService.save(usuario);
	}
	
	@PutMapping(value="/usuario/{id}")
	public Usuario updateUsuario(@Valid @RequestBody Usuario usuario, @PathVariable long id){
		return usuarioService.update(usuario);
	}
	
	@DeleteMapping(path="/usuario/{id}")
	public ResponseEntity<Void> deleteUsuarioById(@PathVariable long id){
		usuarioService.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
