package com.hanu.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hanu.model.Employee;

public class EmployeeMapper {
	public static Employee fromSqlResult(ResultSet rs) throws SQLException {
		return new Employee(rs.getInt("id"), 
							rs.getString("name"),
							rs.getString("address"));
	}
	
	public static List<Employee> listFromSqlResult(ResultSet rs) throws SQLException {
		List<Employee> items = new ArrayList<>();
		while (rs.next()) {
			items.add(fromSqlResult(rs));
		}
		return items;
	}
}
