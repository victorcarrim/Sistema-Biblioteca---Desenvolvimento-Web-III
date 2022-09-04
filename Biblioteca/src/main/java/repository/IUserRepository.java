package repository;

import java.util.List;

import models.User;

public interface IUserRepository {
	public Integer insert(User user);
	
	public Integer update(User user);
	
	public Integer deleteById(Integer userId);
	
	public List<User> findAll();
	
	public User findById(Integer userId);
	
	public User findByEmail(String userEmail, String userPassword);
}
