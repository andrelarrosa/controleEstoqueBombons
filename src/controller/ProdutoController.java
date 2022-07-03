package controller;

import javax.validation.Valid;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Produto;

@RestController
@RequestMapping("/api")
public class ProdutoController {
	@GetMapping(value="/produto")
	public void findAll(Pageable pageable){
		
	}
	
	@PostMapping(value="/produto")
	public void addProduto(@RequestBody Produto produto){

	}
	
	@PutMapping(value="/produto/{id}")
	public void updateProduto(@Valid @RequestBody Produto produto, @PathVariable long id){

	}
	
	@DeleteMapping(path="/produto/{id}")
	public void deleteProdutoById(@PathVariable long id){
		
	}
}
