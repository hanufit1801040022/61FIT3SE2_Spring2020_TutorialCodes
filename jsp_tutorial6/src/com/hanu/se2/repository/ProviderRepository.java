package com.hanu.se2.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hanu.se2.base.Repository;
import com.hanu.se2.db.DbConnector;
import com.hanu.se2.api.model.Provider;
import com.hanu.se2.api.model.mapper.ProviderMapper;

public class ProviderRepository implements Repository<Provider, Integer> {
	
	public List<Provider> findAll() {
		try {
			ResultSet rs = DbConnector.getInstance().executeSelect("SELECT * FROM provider");
			return ProviderMapper.listFromSqlResult(rs);
		} catch (SQLException e) {
			return new ArrayList<>();
		}
	}
	
	@Override
	public Provider findById(Integer id) {
		try {
			ResultSet rs = DbConnector.getInstance().executeSelect("SELECT * FROM provider WHERE id = $id".replace("$id", id.toString()));
			System.out.println("SELECT * FROM provider WHERE id = $id".replace("$id", id.toString()));
			rs.next();
			return ProviderMapper.fromSqlResult(rs);
		} catch (SQLException e) {
			return null;
		}
	}

	@Override
	public int add(Provider item) {
		try {
			return DbConnector.getInstance()
								.executeUpdate("INSERT INTO provider (name) VALUES (?)", 
												item.getName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int add(Iterable<Provider> items) {
		int rowsAffected = 0;
		for (Provider item : items) {
			rowsAffected += add(item);
		}
		return rowsAffected;
	}

	@Override
	public int remove(Integer id) {
		try {
			return DbConnector.getInstance()
								.executeUpdate("DELETE FROM provider WHERE id=?", id.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int save(Provider item) {
		try {
			return DbConnector.getInstance()
								.executeUpdate("UPDATE provider SET name=? WHERE id=?",
												item.getName(),
												String.valueOf(item.getId()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int save(Iterable<Provider> items) {
		// TODO Auto-generated method stub
		return 0;
	}
}
