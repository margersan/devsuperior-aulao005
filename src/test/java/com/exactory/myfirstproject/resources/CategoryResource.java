package com.exactory.myfirstproject.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exactory.myfirstproject.entities.Category;

/*
@RestController  //define que a classe vai ser recurso rest
@RequestMapping(value = "/categories") //mapeamento de url
public class CategoryResource {

	@GetMapping  //para que este método ele seja um endpoint da aplicação do tipo get 
	public ResponseEntity<List<Category>> findAll() {  //método encontrar todos
		List<Category> list = new ArrayList<>();  //Instanciando uma lista hardcode
		list.add(new Category(1L, "Eletronics"));
		list.add(new Category(2L, "Books"));
		return ResponseEntity.ok().body(list); //método de Resposta do grupo 200 - deu tudo certo
	}
*/

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

	@GetMapping 
	public ResponseEntity<List<Category>> findAll() {
		List<Category> list = new ArrayList<>();
		list.add(new Category(1L, "Eletronics"));
		list.add(new Category(2L, "Books"));
		return ResponseEntity.ok().body(list);
	}

	/*
	@GetMapping(value = "/{id}")
	public ResponseEntity<...> findById(@PathVariable Long id) {
		...
		return ResponseEntity.ok().body(...);
	}
	*/
}
