package com.exactory.myfirstproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exactory.myfirstproject.entities.Category;

@Repository //anotation para usar a interface de repository do spring boot
public interface CategoryRepository extends JpaRepository<Category, Long> { //utilização como interface (entender melhor)

}
