package com.hanu.se2.base;

import java.io.Serializable;
import java.util.List;

public interface RestService<T, ID extends Serializable> {
	List<T> getAll();
	T getById(ID id);
}
