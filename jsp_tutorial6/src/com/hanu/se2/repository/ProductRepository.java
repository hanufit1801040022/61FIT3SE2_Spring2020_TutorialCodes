package com.hanu.se2.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hanu.se2.base.Repository;
import com.hanu.se2.db.DbConnector;
import com.hanu.se2.api.model.Product;
import com.hanu.se2.api.model.mapper.ProductMapper;

public class ProductRepository implements Repository<Product, Integer> {
	
	public List<Product> findAll() {
		try {
			ResultSet rs = DbConnector.getInstance().executeSelect("SELECT * FROM product");
			return ProductMapper.listFromSqlResult(rs);
		} catch (SQLException e) {
			return new ArrayList<>();
		}
	}
	
	@Override
	public Product findById(Integer id) {
		try {
			ResultSet rs = DbConnector.getInstance().executeSelect("SELECT * FROM product WHERE id = $id".replace("$id", id.toString()));
			rs.next();
			return ProductMapper.fromSqlResult(rs);
		} catch (SQLException e) {
			return null;
		}
	}

	@Override
	public int add(Product item) {
		try {
			return DbConnector.getInstance()
								.executeUpdate("INSERT INTO product (name, listPrice) VALUES (?, ?)", 
												item.getName(), String.valueOf(item.getListPrice()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int add(Iterable<Product> items) {
		int rowsAffected = 0;
		for (Product item : items) {
			rowsAffected += add(item);
		}
		return rowsAffected;
	}

	@Override
	public int remove(Integer id) {
		try {
			return DbConnector.getInstance()
								.executeUpdate("DELETE FROM product WHERE id=?", id.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int save(Product item) {
		try {
			return DbConnector.getInstance()
								.executeUpdate("UPDATE product SET name=?, listPrice=? WHERE id=?",
												item.getName(),
												String.valueOf(item.getListPrice()),
												String.valueOf(item.getId()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int save(Iterable<Product> items) {
		// TODO Auto-generated method stub
		return 0;
	}
}
