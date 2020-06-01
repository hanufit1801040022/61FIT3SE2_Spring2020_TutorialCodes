package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import connect.DBConnect;
import model.User;

/**
 * This is a DAO (DATA ACCESS OBJECT) class which provides CRUD (CREATE - READ -
 * UPDATE - DELETE) database operations for the table user in the database
 */
public class UserDAO {
	private static final Logger LOGGER = Logger.getLogger(UserDAO.class.getName());

	public UserDAO() {
	}

	public List<User> selectAllUsers() {

		List<User> users = new ArrayList<>();
		// Step 1: Establishing a Connection
		Connection connection = DBConnect.getConnection();
		try {
			// Step 2:Create a statement using connection object
			String SELECT_ALL_USERS = "SELECT * FROM user";
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 4: Process the ResultSet object
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String address = rs.getString("address");
				String mobile = rs.getString("mobile");
				users.add(new User(id, name, address, mobile));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	// TO-DO: Implement selectUser() method to select user by ID (using in UPDATE function)
	public User selectUser(int id) {
		User user = null;
		try {
			Connection connection = DBConnect.getConnection();
			String statement = "SELECT * FROM user WHERE id = $id";
			ResultSet rs = connection.createStatement().executeQuery(statement.replace("$id", String.valueOf(id)));
			rs.next();
			String name = rs.getString("name");
			String address = rs.getString("address");
			String mobile = rs.getString("mobile");
			user = new User(id, name, address, mobile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}

	// TO-DO: Implement insertUser() method to add new record to table User  
	public void insertUser(User user) throws SQLException {
		Connection connection = DBConnect.getConnection();
		String sql = "INSERT INTO user (name, address, mobile) VALUES (?, ?, ?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, user.getName());
		statement.setString(2, user.getAddress());
		statement.setString(3, user.getMobile());
		int rowsAffected = statement.executeUpdate();
		LOGGER.info("Completed, $rows_updated row(s) updated.".replace("$rows_updated", String.valueOf(rowsAffected)));
	}

	// TO-DO: Implement updateUser() method to update record in table User  
	public boolean updateUser(User user) throws SQLException {
		Connection connection = DBConnect.getConnection();
		boolean rowUpdated = false;
		String sql = "UPDATE user SET name='$name', address='$address', mobile='$mobile' WHERE id=$id";
		int rowsAffected = connection.createStatement()
									.executeUpdate(sql.replace("$name", user.getName())
													.replace("$address", user.getAddress())
													.replace("$mobile", user.getMobile())
													.replace("$id", String.valueOf(user.getId())));
		rowUpdated = rowsAffected != 0;
		return rowUpdated;
	}

	// TO-DO: Implement updateUser() method to delete record in table User  
	public boolean deleteUser(int id) throws SQLException {
		Connection connection = DBConnect.getConnection();
		boolean rowDeleted = false;
		String sql = "DELETE FROM user WHERE id = $id";
		Statement statement = connection.createStatement();
		int rowsAffected = statement.executeUpdate(sql.replace("$id", String.valueOf(id)));
		LOGGER.info("Completed, $rows_updated row(s) updated.".replace("$rows_updated", String.valueOf(rowsAffected)));
		return rowDeleted;
	}
}
