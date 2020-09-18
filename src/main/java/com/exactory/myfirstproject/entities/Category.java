package com.exactory.myfirstproject.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

//biblioteca responsável por serializar 
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id //campo que será o id da tabela
	@GeneratedValue(strategy = GenerationType.IDENTITY) //indica que ele será auto incremetal
	private Long id;
	private String name;
	
	//implementando a referência da classe product dentro da categoria (relação ManyToOne)
	@JsonIgnore //para evitar referência circular (categoria chamando produto que chama categoria), uscamos anotation JsonIgnore
	@OneToMany(mappedBy = "category")  //relacionamento 1 categoria para n produtos (precisa indicar o nome do atributo da tabela product)
	//@JoinColumn(name = "product_id") //nome da chave strangeira na tabela
	private List<Product> products = new ArrayList<>();
	
	public Category() {
	}

	public Category(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	//Implementando os getters and setters para acessar a lista de produtos
	//não podemos trocar os produtos, então não teremos setter para a lista de produtos em questão
	public List<Product> getProducts() {
		return products;
	}
	
}
