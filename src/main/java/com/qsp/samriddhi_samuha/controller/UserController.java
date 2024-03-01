package com.qsp.samriddhi_samuha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.samriddhi_samuha.dto.User;
import com.qsp.samriddhi_samuha.service.UserService;
import com.qsp.samriddhi_samuha.util.ResponseStructure;

@RestController
public class UserController 
{
	@Autowired
	private UserService service ;
	
	@PostMapping("/user")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user) 
	{
		return service.saveUser(user) ;
	}
	
	@GetMapping("/user")
	public ResponseEntity<ResponseStructure<User>> getUser(@RequestParam int id) 
	{
		return service.getUser(id) ;
	}
	
	@GetMapping("/allUser")
	public ResponseEntity<ResponseStructure<List<User>>> getAll()
	{
		return service.getAllUser() ;
	}
	
	@DeleteMapping("/user")
	public ResponseEntity<ResponseStructure<User>> deleteUser(@RequestParam int id) 
	{
		return service.deleteUser(id) ;
	}
	
	@PutMapping("/user/{id}")
	public ResponseEntity<ResponseStructure<User>> updateUser( @PathVariable int id, @RequestBody User user) 
	{
		return service.updateUser(id, user) ;
	}
}
