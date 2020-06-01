package com.hanu.se2.api.service;

import java.util.List;

import com.hanu.se2.api.model.Provider;
import com.hanu.se2.base.Repository;
import com.hanu.se2.base.RestService;
import com.hanu.se2.repository.ProviderRepository;

public class ProviderService implements RestService<Provider, Integer> {
	private Repository<Provider, Integer> repository;
	
	public ProviderService() {
		repository = new ProviderRepository();
	}

	@Override
	public List<Provider> getAll() {
		return repository.findAll();
	}

	@Override
	public Provider getById(Integer id) {
		return repository.findById(id);
	}
}
