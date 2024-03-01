package com.qsp.samriddhi_samuha.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.samriddhi_samuha.dto.User;
import com.qsp.samriddhi_samuha.exception.IdNotFound;
import com.qsp.samriddhi_samuha.repo.UserRepo;

@Repository
public class UserDao 
{
	@Autowired
	private UserRepo repo ;
	
	public User saveUser(User user) 
	{
		return repo.save(user) ;
	}
	
	public User getUser(int id) 
	{
		Optional<User> optional = repo.findById(id) ;
		if (optional.isPresent()) 
		{
			return optional.get() ;
		}
		throw new IdNotFound("User with given id is not present...!!");
	}
	
	public List<User> getAllUser() 
	{
		return repo.findAll() ;
	}
	
	public User deleteUser(int id) 
	{
		Optional<User> optional = repo.findById(id) ;
		if (optional.isEmpty()) 
		{
			throw new IdNotFound("User with given id is not present...!!");
		}
		repo.deleteById(id);
		return optional.get() ;
	}
	
	public User updateUser(int id, User user) 
	{
		Optional<User> optional = repo.findById(id) ;
		if (optional.isEmpty()) 
		{
			throw new IdNotFound("User with given id is not present...!!");
		}
		user.setId(id);
		return repo.save(user) ;
	}
}
