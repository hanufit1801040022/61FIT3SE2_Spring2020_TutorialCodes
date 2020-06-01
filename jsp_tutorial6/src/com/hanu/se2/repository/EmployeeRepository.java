package com.hanu.se2.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hanu.se2.base.Repository;
import com.hanu.se2.db.DbConnector;
import com.hanu.se2.api.model.Employee;
import com.hanu.se2.api.model.mapper.EmployeeMapper;

public class EmployeeRepository implements Repository<Employee, Integer> {
	
	public List<Employee> findAll() {
		try {
			ResultSet rs = DbConnector.getInstance().executeSelect("SELECT * FROM employee");
			return EmployeeMapper.listFromSqlResult(rs);
		} catch (SQLException e) {
			return new ArrayList<>();
		}
	}

	@Override
	public Employee findById(Integer id) {
		try {
			ResultSet rs = DbConnector.getInstance().executeSelect("SELECT * FROM employee WHERE id = $id".replace("$id", id.toString()));
			rs.next();
			return EmployeeMapper.fromSqlResult(rs);
		} catch (SQLException e) {
			return null;
		}
	}

	@Override
	public int add(Employee item) {
		try {
			return DbConnector.getInstance()
								.executeUpdate("INSERT INTO employee (name, address) VALUES (?, ?)", item.getName(), item.getAddress());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int add(Iterable<Employee> items) {
		int rowsAffected = 0;
		for (Employee item : items) {
			rowsAffected += add(item);
		}
		return rowsAffected;
	}

	@Override
	public int remove(Integer id) {
		try {
			return DbConnector.getInstance()
								.executeUpdate("DELETE FROM employee WHERE id=?", id.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int save(Employee item) {
		try {
			return DbConnector.getInstance()
								.executeUpdate("UPDATE employee SET name=?, address=? WHERE id=?",
												item.getName(),
												item.getAddress(),
												String.valueOf(item.getId()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int save(Iterable<Employee> items) {
		// TODO Auto-generated method stub
		return 0;
	}
}
