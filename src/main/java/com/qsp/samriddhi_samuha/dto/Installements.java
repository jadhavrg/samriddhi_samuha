package com.qsp.samriddhi_samuha.dto;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Installements 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	private double amount ;
	private Date date ;
}
