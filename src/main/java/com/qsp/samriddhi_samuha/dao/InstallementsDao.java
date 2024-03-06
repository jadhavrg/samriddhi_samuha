package com.qsp.samriddhi_samuha.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.samriddhi_samuha.dto.Installements;
import com.qsp.samriddhi_samuha.repo.InstallementsRepo;

@Repository
public class InstallementsDao 
{
	@Autowired
	private InstallementsRepo repo ;
	
	public Installements addInstallements(Installements installements) 
	{
		return repo.save(installements) ;
	}
	
	public Installements getInstallements(int id)
	{
		Optional<Installements> optional = repo.findById(id) ;
		if (optional.isEmpty()) 
		{
			return null ;
		}
		return optional.get() ;
	}
	
	public List<Installements> getAllInstallements()
	{
		return repo.findAll() ;
	}
	
	public Installements deleteInstallements(int id) 
	{
		Optional<Installements> optional = repo.findById(id) ;
		if (optional.isPresent()) 
		{
			repo.deleteById(id) ;
			return optional.get() ;
		}
		return null ;
	}
	
	public Installements updateInstallements(int id, Installements installements) 
	{
		Optional<Installements> optional = repo.findById(id) ;
		if(optional.isEmpty())
		{
			return null ;
		}
		installements.setId(id);
		return repo.save(installements) ;
	}
}
