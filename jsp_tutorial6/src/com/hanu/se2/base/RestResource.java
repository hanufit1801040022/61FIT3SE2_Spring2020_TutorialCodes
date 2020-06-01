package com.hanu.se2.base;

import java.io.Serializable;
import java.util.List;

public abstract class RestResource<T, ID extends Serializable> {
	protected RestService<T, ID> service;
	
	public List<T> get() {
		return service.getAll();
	}
	
	public T getById(ID id) {
		return service.getById(id);
	}
}
