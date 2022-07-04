package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import exception.BadResourceException;
import exception.ResourceAlreadyExistsException;
import model.Cliente;
import repository.ClienteRepository;

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
	
	public Cliente save(Cliente cliente) throws ResourceAlreadyExistsException, BadResourceException{
		if(!StringUtils.isEmpty(cliente.getNome())) {
			if(cliente.getId() != 0 && existsbyId(cliente.getId())) {
				throw new ResourceAlreadyExistsException("Categoria com o id: "+cliente.getId()+"\n já existe");
			}
			return clienteRepository.save(cliente);
		}else {
			BadResourceException exc = new BadResourceException("Erro ao salvar categoria");
			exc.addErrorMessage("Categoria está vazio ou é nulo");
			throw exc;
		}
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
