package com.qsp.samriddhi_samuha.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.samriddhi_samuha.dto.User;

public interface UserRepo extends JpaRepository<User, Integer>
{

}
