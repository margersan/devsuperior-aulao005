package com.exactory.myfirstproject;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.exactory.myfirstproject.entities.Category;
import com.exactory.myfirstproject.entities.Product;
import com.exactory.myfirstproject.repositories.CategoryRepository;
import com.exactory.myfirstproject.repositories.ProductRepository;

@SpringBootApplication
public class MyfirstprojectApplication implements CommandLineRunner { //CommandLineRunner (é um inicializador)

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
		
	public static void main(String[] args) {
		SpringApplication.run(MyfirstprojectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {  //Por ser interface, precisou ser implementado na classe principal
		// instanciação das classes para inserir no MAP da CategoryRepositor
		// repository dentro da memória
		Category cat1 = new Category(null, "Eletronics");
		Category cat2 = new Category(null, "Books");
		
		//Adicionando os produtos já fazendo referência a categoria na qual pertencem
		Product p1 = new Product(null, "TV", 2200.00, cat1);
		Product p2 = new Product(null, "Domain Driven", 120.00, cat2);
		Product p3 = new Product(null, "PS5", 2800.00, cat1);
		Product p4 = new Product(null, "Docker", 100.00, cat2);
		
		//Adicionando as listas de produtos dentro da classe Categoria
		//método Arrays.asList cria uma lista com elementos existentes
		cat1.getProducts().addAll(Arrays.asList(p1, p3));
		cat2.getProducts().addAll(Arrays.asList(p2, p4));
		
		
		categoryRepository.save(cat1);
		categoryRepository.save(cat2);
		
		productRepository.save(p1);
		productRepository.save(p2);
		productRepository.save(p3);
		productRepository.save(p4);
	}

}
