package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import models.User;

public class UserRepository implements IUserRepository{
	private Connection connection;
	
	public UserRepository() {
		connection = ConnectionFactory.getConnection();
	}
	@Override
	public Integer insert(User user) {
		PreparedStatement stmt = null;
		int userInsert = 0;
		try {
			String sql = "insert into user (name, email, password, type) values (?, ?, ?, ?)";
			stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getPassword());
			stmt.setString(4, user.getTypeDAO());
			
			int rowsAffected = stmt.executeUpdate();
			
			if(rowsAffected > 0 ) {
				userInsert = 1;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return userInsert;
	}

	@Override
	public Integer update(User user) {
		PreparedStatement stmt = null;
		
		try {
			String sql = "update user set name = ? , email = ? , password = ? , type = ? where idtbUser = ?";
			stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getPassword());
			stmt.setString(4, user.getTypeDAO());
			stmt.setInt(5, user.getId());
			
			int rowsAffected = stmt.executeUpdate();
			
			if(rowsAffected > 0 ) {
				ResultSet ids = stmt.getGeneratedKeys();
				while(ids.next()) {
					int id = ids.getInt(1);
					System.out.println("Ok, user atualizado: " + id);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public Integer deleteById(Integer userId) {
		PreparedStatement stmt = null;
		
		try {
			String sql = "delete from user where (idtbUser = ?)";
			stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, userId);
			
			int rowsAffected = stmt.executeUpdate();
			System.out.println("Rows Affected: " + rowsAffected);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return userId;
	}

	@Override
	public List<User> findAll() {
		List<User> usersList = new ArrayList<User>();
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		try {
			stmt =  connection.prepareStatement("Select * from user");
			result = stmt.executeQuery();
			
			while(result.next()) {
				Integer id = result.getInt("idtbUser");
				String name = result.getString("name");
				String email = result.getString("email");
				String password = result.getString("password");
				String type = result.getString("type");
				User userObject = new User(id, name, email, password, type);
				usersList.add(userObject);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
			}
		
		return usersList;
	}

	@Override
	public User findById(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public User findByEmail(String userEmail, String userPassword) {
		PreparedStatement stmt = null;
		ResultSet result = null;
		User userObject = null;
		
		try {
			stmt = connection.prepareStatement("Select * from user where email = ?");
			stmt.setString(1, userEmail);
			result = stmt.executeQuery();
			
			while(result.next()) {
				Integer id = result.getInt("idtbUser");
				String name = result.getString("name");
				String email = result.getString("email");
				String password = result.getString("password");
				String type = result.getString("type");
				
				if(email.equals(userEmail) && password.equals(userPassword)) {
					userObject = new User(id, name, email, password, type);
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());		
			}
		return userObject;
	}

}
