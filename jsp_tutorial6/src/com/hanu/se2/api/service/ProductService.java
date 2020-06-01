package com.hanu.se2.api.service;

import java.util.List;

import com.hanu.se2.api.model.Product;
import com.hanu.se2.base.Repository;
import com.hanu.se2.base.RestService;
import com.hanu.se2.repository.ProductRepository;

public class ProductService implements RestService<Product, Integer> {
	private Repository<Product, Integer> repository;
	
	public ProductService() {
		repository = new ProductRepository();
	}

	@Override
	public List<Product> getAll() {
		return repository.findAll();
	}

	@Override
	public Product getById(Integer id) {
		return repository.findById(id);
	}
}
