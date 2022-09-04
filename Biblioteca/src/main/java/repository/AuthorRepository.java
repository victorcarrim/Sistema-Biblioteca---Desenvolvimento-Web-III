package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import models.Author;

public class AuthorRepository implements IAuthorRepository{
	private Connection connection;
	
	public AuthorRepository() {
		this.connection = ConnectionFactory.getConnection();
	}

	@Override
	public Integer insert(Author author) {
		PreparedStatement stmt = null;
		
		try {
			String sql = "insert into author (name) values (?)";
			stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, author.getName());
			
			int rowsAffected = stmt.executeUpdate();
			
			if(rowsAffected > 0 ) {
				ResultSet ids = stmt.getGeneratedKeys();
				while(ids.next()) {
					int id = ids.getInt(1);
					System.out.println("Ok, id inserido: " + id);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public Integer update(Author author) {
		PreparedStatement stmt = null;
		
		try {
			String sql = "Update author set name = ? where idtbAuthor = ?";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, author.getName());
			stmt.setDouble(2, author.getId());
			
			stmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public Integer deleteById(Integer userId) {
		PreparedStatement stmt = null;
		
		try {
			String sql = "delete from author where (idtbAuthor = ?)";
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
	public List<Author> findAll() {
		List<Author> authorsList = new ArrayList<Author>();
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		try {
			stmt =  connection.prepareStatement("Select * from author");
			result = stmt.executeQuery();
			
			while(result.next()) {
				Integer id = result.getInt("idtbAuthor");
				String name = result.getString("name");
				Author authorObject = new Author(id, name);
				authorsList.add(authorObject);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
			}
		
		return authorsList;
		
	}

	@Override
	public Author findById(Integer authorId) {
		PreparedStatement stmt = null;
		ResultSet result = null;
		Author authorObject = null;
		
		try {
			stmt = connection.prepareStatement("Select * from author where idtbAuthor = ?");
			stmt.setInt(1, authorId);
			result = stmt.executeQuery();
			
			while(result.next()) {
				Integer id = result.getInt("idtbAuthor");
				String name = result.getString("name");
				authorObject = new Author(id, name);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());		
			}
		
		return authorObject;
	}
}
