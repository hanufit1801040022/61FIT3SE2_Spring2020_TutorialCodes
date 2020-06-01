package com.hanu.base;

import java.io.Serializable;
import java.util.List;

public interface Repository<T, ID extends Serializable> {
	List<T> findAll();
	T findById(ID id);
	int add(T item);
	int add(Iterable<T> items);
	int remove(ID id);
	int save(T item);
	int save(Iterable<T> items);	
}
