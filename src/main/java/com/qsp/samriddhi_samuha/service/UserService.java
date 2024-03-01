package com.qsp.samriddhi_samuha.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.samriddhi_samuha.dao.UserDao;
import com.qsp.samriddhi_samuha.dto.User;
import com.qsp.samriddhi_samuha.exception.IdNotFound;
import com.qsp.samriddhi_samuha.util.ResponseStructure;

@Service
public class UserService
{
	@Autowired
	private UserDao dao ;
	
	public ResponseEntity<ResponseStructure<User>> saveUser(User user) 
	{
		ResponseStructure<User> structure = new ResponseStructure<>() ;
		structure.setMessage("Data is saved..!");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveUser(user));
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.CREATED) ;
	}
	
	public ResponseEntity<ResponseStructure<User>> getUser(int id) 
	{
		User user = dao.getUser(id) ;
		ResponseStructure<User> structure = new ResponseStructure<>() ;
		if (user != null) 
		{
			structure.setMessage("User is found..!!");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dao.getUser(id));
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.FOUND) ;
		}
		throw new IdNotFound("User with given "+id+ " is not present") ;
	}
	
	public ResponseEntity<ResponseStructure<List<User>>> getAllUser()
	{
		ResponseStructure<List<User>> structure = new ResponseStructure<>() ;
		structure.setMessage("Users are found..!");
		structure.setStatus(HttpStatus.FOUND.value());
		structure.setData(dao.getAllUser());
		return new ResponseEntity<ResponseStructure<List<User>>>(structure, HttpStatus.FOUND) ;
	}
	
	public ResponseEntity<ResponseStructure<User>> deleteUser(int id) 
	{
		User user = dao.getUser(id) ;
		ResponseStructure<User> structure = new ResponseStructure<>() ;
		if (user != null) 
		{
			structure.setMessage("User is deleted..!");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.deleteUser(id));
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK) ;
		}
		throw new IdNotFound("User with given "+id+ " is not present") ;
		
	}
	
	public ResponseEntity<ResponseStructure<User>> updateUser(int id, User user) 
	{
		User dbUser = new User() ;
		ResponseStructure<User> structure = new ResponseStructure<>() ;
		if (dbUser != null) 
		{
			structure.setMessage("User is updated..!");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.updateUser(id, user));
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK) ;
		}
		
		throw new IdNotFound("User with given "+id+ " is not present") ;
	}
}
