package com.hanu.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hanu.model.Provider;

public class ProviderMapper {
	public static Provider fromSqlResult(ResultSet rs) throws SQLException {
		return new Provider(rs.getInt("id"), 
							rs.getString("name"));
	}
	
	public static List<Provider> listFromSqlResult(ResultSet rs) throws SQLException {
		List<Provider> items = new ArrayList<>();
		while (rs.next()) {
			items.add(fromSqlResult(rs));
		}
		return items;
	}
}
