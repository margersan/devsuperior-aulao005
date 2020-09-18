package com.exactory.myfirstproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exactory.myfirstproject.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
