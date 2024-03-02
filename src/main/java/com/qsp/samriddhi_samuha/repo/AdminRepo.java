package com.qsp.samriddhi_samuha.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.samriddhi_samuha.dto.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer>
{
	Admin findAdminByEmail(String email) ;
}
