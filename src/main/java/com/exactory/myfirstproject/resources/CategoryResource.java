package com.exactory.myfirstproject.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exactory.myfirstproject.entities.Category;
import com.exactory.myfirstproject.repositories.CategoryRepository;

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
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id) { //anotatopn @PathVariable (id colocado no endpoint)
		Category cat = new Category(1L, "Eletronics");
		return ResponseEntity.ok().body(cat);
	}
}
*/

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

	@Autowired //injeção de dependência para trazer os dados do repositório para o resource;
	private CategoryRepository categoryRepository;
	
	@GetMapping 
	public ResponseEntity<List<Category>> findAll() {
		/*
		List<Category> list = new ArrayList<>();
		list.add(new Category(1L, "Eletronics"));
		list.add(new Category(2L, "Books"));
		return ResponseEntity.ok().body(list);
		*/  //Retirada dos HardCodes
		
		List<Category> list = categoryRepository.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id) { //anotatopn @PathVariable (id colocado no endpoint)
		//Category cat = new Category(1L, "Eletronics");
		Category cat = categoryRepository.findById(id).get(); //inserido um .get pois o findById retorna um optional
		return ResponseEntity.ok().body(cat);
	}
}
