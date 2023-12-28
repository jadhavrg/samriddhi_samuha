package com.qsp.samriddhi_samuha.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Loans
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	private double loanAmount ;
	private long loanAccountNumber ;
	private double dueAmount ;
}
