package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import model.Usuario;
import repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	private boolean existsbyId(Long id) {
		return usuarioRepository.existsById(id);
	}
	
	public Usuario findById(Long id){
		Usuario usuario = usuarioRepository.findById(id).orElse(null);
		return usuario;
	}
	
	public Page<Usuario> findAll(Pageable pageable){
		return usuarioRepository.findAll(pageable);
	}
	
	public Usuario save(Usuario usuario){
		return usuarioRepository.save(usuario);
	}
	
	public Usuario update(Usuario usuario){
	    return usuarioRepository.save(usuario);
	}
	
	public void deleteById(Long id){
		usuarioRepository.deleteById(id);
	}
	
	public Long count() {
		return usuarioRepository.count();
	}

}
