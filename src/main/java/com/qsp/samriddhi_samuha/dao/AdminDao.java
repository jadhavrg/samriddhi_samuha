package com.qsp.samriddhi_samuha.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.samriddhi_samuha.dto.Admin;
import com.qsp.samriddhi_samuha.repo.AdminRepo;

@Repository
public class AdminDao 
{
	@Autowired
	private AdminRepo repo ;
	public Admin saveAdmin(Admin admin) 
	{
		return repo.save(admin) ;
	}
	
//	public Admin getAdmin(int id) 
//	{
//		Optional<Admin> optional = repo.findById(id) ;
//		if (optional.isEmpty()) 
//		{
//			return null ;
//		}
//		return optional.get() ;
//	}
	
	public Admin logIn(String email, String password) 
	{
		Admin admin = repo.findAdminByEmail(email) ;
		if (admin.getPassword().equals(password)) 
		{
			return admin ;
		}
		return null ;
	}
}
