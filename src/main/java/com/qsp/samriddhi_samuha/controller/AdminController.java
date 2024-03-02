package com.qsp.samriddhi_samuha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.samriddhi_samuha.dto.Admin;
import com.qsp.samriddhi_samuha.service.AdminService;
import com.qsp.samriddhi_samuha.util.ResponseStructure;

@RestController
public class AdminController 
{
	@Autowired
	private AdminService service ;
	
	@PostMapping("/admin")
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(@RequestBody Admin admin) 
	{
		return service.saveAdmin(admin) ;
	}
	
	@GetMapping("/admin ")
	public ResponseEntity<ResponseStructure<Admin>> logIn(@RequestParam String email,@RequestParam String password) 
	{
		return service.logIn(email, password) ;
	}
}
