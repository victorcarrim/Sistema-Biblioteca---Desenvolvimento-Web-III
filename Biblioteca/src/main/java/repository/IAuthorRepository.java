package repository;

import java.util.List;

import models.Author;

public interface IAuthorRepository {
	public Integer insert(Author author);
	
	public Integer update(Author author);
	
	public Integer deleteById(Integer userId);
	
	public List<Author> findAll();
	
	public Author findById(Integer authorId);
}
