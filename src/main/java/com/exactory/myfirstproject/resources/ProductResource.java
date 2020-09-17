package com.exactory.myfirstproject.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exactory.myfirstproject.entities.Product;
import com.exactory.myfirstproject.repositories.ProductRepository;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

	@Autowired //injeção de dependência para trazer os dados do repositório para o resource;
	private ProductRepository productRepository;
	
	@GetMapping 
	public ResponseEntity<List<Product>> findAll() {
		List<Product> list = productRepository.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) { //anotation @PathVariable (id colocado no endpoint)
		Product cat = productRepository.findById(id);
		return ResponseEntity.ok().body(cat);
	}
}
