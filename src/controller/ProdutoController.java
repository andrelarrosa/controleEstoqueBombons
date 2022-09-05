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

import model.Produto;
import service.ProdutoService;

@RestController
@RequestMapping("/api")
public class ProdutoController {
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping(value="/produto/")
	public ResponseEntity<Page<Produto>> findAll(Pageable pageable){
		return ResponseEntity.ok(produtoService.findAll(pageable));
	}
	
	@PostMapping(value="/produto/")
	public Produto addProduto(@RequestBody Produto produto){
		return produtoService.save(produto);
	}
	
	@PutMapping(value="/produto/{id}")
	public Produto updateProduto(@Valid @RequestBody Produto produto, @PathVariable long id){
		return produtoService.update(produto);
	}
	
	@DeleteMapping(path="/produto/{id}")
	public ResponseEntity<Void> deleteProdutoById(@PathVariable long id){
		produtoService.deleteById(id);
		return ResponseEntity.ok().build();
	}
}