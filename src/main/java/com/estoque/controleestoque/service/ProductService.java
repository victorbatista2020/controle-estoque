package com.estoque.controleestoque.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.estoque.controleestoque.model.Product;
import com.estoque.controleestoque.repository.ProductRepository;

@Service
public class ProductService {
	
	private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product register(Product product) {
        return repository.save(product);
    }

    public List<Product> listAll() {
        return repository.findAll();
    }

    public Product findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public Product update(Long id, Product product) {
    	Product existing = findById(id);

    	existing.setName(product.getName());
    	existing.setPrice(product.getPrice());
    	existing.setAmount(product.getAmount());

        return repository.save(existing);
    }

    public void delete(Long id) {
    	Product existing = findById(id);
        repository.delete(existing);
    }

}
