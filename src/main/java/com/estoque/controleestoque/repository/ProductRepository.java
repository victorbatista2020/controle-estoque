package com.estoque.controleestoque.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.estoque.controleestoque.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
