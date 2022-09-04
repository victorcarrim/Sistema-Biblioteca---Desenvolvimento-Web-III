package repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import models.Book;

public class BookRepository implements IBookRepository{
	private Connection connection;
	
	public BookRepository() {
		connection = ConnectionFactory.getConnection();
	}
	
	@Override
	public Integer insert(Book book) {
		PreparedStatement stmt = null;
		
		try {
			String sql = "insert into book (name, dateBook, idtbAuthor, status) values (?, ?, ?, ?)";
			stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, book.getName());
			stmt.setDate(2, book.getDateDAO());
			stmt.setInt(3, book.getAuthor().getId());
			stmt.setInt(4, book.getStatus().ordinal());
			
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
	public Integer update(Book book) {
		PreparedStatement stmt = null;
		
		try {
			String sql = "update book set name = ?, dateBook = ?, idtbAuthor = ?, status = ? where idtbBook = ?";
			stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, book.getName());
			stmt.setDate(2, book.getDateDAO());
			stmt.setInt(3, book.getAuthor().getId());
			stmt.setInt(4, book.getStatus().ordinal());
			stmt.setInt(5, book.getId());
			
			stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public Integer deleteById(Integer bookId) {
		PreparedStatement stmt = null;
		
		try {
			String sql = "delete from book where (idtbBook = ?)";
			stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, bookId);
			
			int rowsAffected = stmt.executeUpdate();
			System.out.println("Rows Affected: " + rowsAffected);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return bookId;
	}

	@Override
	public List<Book> findAll() {
		List<Book> booksList = new ArrayList<Book>();
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		try {
			stmt =  connection.prepareStatement("Select * from book");
			result = stmt.executeQuery();
			
			while(result.next()) {
				AuthorRepository author = new AuthorRepository();
				Integer id = result.getInt("idtbBook");
				String name = result.getString("name");
				Date date = result.getDate("dateBook");
				Integer authorId = result.getInt("idtbAuthor");
				Integer status = result.getInt("status");
				Book bookObject = new Book(id, name, date, author.findById(authorId), status);
				booksList.add(bookObject);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
			}
		
		return booksList;
	}

	@Override
	public Book findById(Integer bookId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book findByName(String bookName) {
		// TODO Auto-generated method stub
		return null;
	}

}
