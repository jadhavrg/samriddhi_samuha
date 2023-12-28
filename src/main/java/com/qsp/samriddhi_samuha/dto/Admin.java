package com.qsp.samriddhi_samuha.dto;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Admin
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	private String name ;
	@Column(unique = true)
	private long phone ;
	@Column(unique = true)
	private String email ;
	private String password ;
	private Date dob ;
	private long accountNumber ;
	@OneToOne
	private Loans loans ;
	@OneToMany
	private List<Installements> installements ;
}
