package com.ativaval.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.ativaval.entity.Produto;
import com.ativaval.service.ProdutoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
	private final ProdutoService produtoService;

	@Autowired
	public ProdutoController (ProdutoService produtoService) {
		this.produtoService = produtoService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity <Produto> buscaProdutoIdControlId(@PathVariable Long id){
		Produto produto = produtoService.buscaProdutoId(id);
		if(produto!= null) {
			return ResponseEntity.ok(produto);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping
	public ResponseEntity<List<Produto>> buscaTodosProdutoControl() {
		List<Produto> Produto = produtoService.buscaTodosProduto();

		return ResponseEntity.ok(Produto);
	}
	
	@PostMapping
	public ResponseEntity<Produto> salvaProdutoControl(@RequestBody @Valid Produto produto){
		Produto salvaProduto= produtoService.salvaProduto(produto);

		return ResponseEntity.status(HttpStatus.CREATED).body(salvaProduto);

	}
	
	@PutMapping ("/{id}")
	public ResponseEntity<Produto> alterarProduto(@PathVariable Long id, @RequestBody @Valid Produto produto) {
		Produto alterarProduto = produtoService.alterarProduto(id,produto);
		if (alterarProduto  != null) {
			return ResponseEntity.ok(alterarProduto);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> apagaProdutoControl(@PathVariable Long id) {
		boolean apagar = produtoService.apagarProduto(id);
		if(apagar) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}
