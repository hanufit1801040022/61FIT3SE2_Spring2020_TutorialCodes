package com.hanu.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hanu.model.Product;

public class ProductMapper {
	public static Product fromSqlResult(ResultSet rs) throws SQLException {
		return new Product(rs.getInt("id"), 
							rs.getString("name"),
							rs.getLong("listPrice"));
	}
	
	public static List<Product> listFromSqlResult(ResultSet rs) throws SQLException {
		List<Product> items = new ArrayList<>();
		while (rs.next()) {
			items.add(fromSqlResult(rs));
		}
		return items;
	}
}
