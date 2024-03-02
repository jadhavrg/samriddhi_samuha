package com.qsp.samriddhi_samuha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.samriddhi_samuha.dao.AdminDao;
import com.qsp.samriddhi_samuha.dto.Admin;
import com.qsp.samriddhi_samuha.exception.InvalidCredentials;
import com.qsp.samriddhi_samuha.util.ResponseStructure;

@Service
public class AdminService 
{
	@Autowired
	private AdminDao dao ;
	
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(Admin admin) 
	{
		ResponseStructure<Admin> structure = new ResponseStructure<>() ;
		structure.setMessage("Account is created..!!");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveAdmin(admin));
		return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.CREATED) ;
	}
	
	public ResponseEntity<ResponseStructure<Admin>> logIn(String email, String password) 
	{
		Admin admin = dao.logIn(email, password) ;
		if (admin != null) 
		{
			ResponseStructure<Admin> structure = new ResponseStructure<>() ;
			structure.setMessage("Login successfully...!!!");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.logIn(email, password));
			return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.OK) ;
		}
		
		throw new InvalidCredentials("Invalid Credentials...!!!") ;
		
	}
}
