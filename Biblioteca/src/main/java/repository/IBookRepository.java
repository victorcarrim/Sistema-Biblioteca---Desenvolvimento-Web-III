package repository;

import java.util.List;

import models.Book;

public interface IBookRepository {

	public Integer insert(Book book);
	
	public Integer update(Book book);
	
	public Integer deleteById(Integer bookId);
	
	public List<Book> findAll();
	
	public Book findById(Integer bookId);
	
	public Book findByName(String bookName);
	
	
}
