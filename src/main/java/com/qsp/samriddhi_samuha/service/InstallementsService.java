package com.qsp.samriddhi_samuha.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.samriddhi_samuha.dao.InstallementsDao;
import com.qsp.samriddhi_samuha.dto.Installements;
import com.qsp.samriddhi_samuha.exception.InstallementsIsNotFound;
import com.qsp.samriddhi_samuha.util.ResponseStructure;

@Service
public class InstallementsService 
{
	@Autowired
	private InstallementsDao dao ;
	
	public ResponseEntity<ResponseStructure<Installements>> addInstallements(Installements installements) 
	{
		ResponseStructure<Installements> structure = new ResponseStructure<>() ;
		structure.setMessage("Installements is added Successfully...!!");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.addInstallements(installements));
		return new ResponseEntity<ResponseStructure<Installements>>(structure, HttpStatus.CREATED) ;	
	}
	
	public ResponseEntity<ResponseStructure<Installements>> getInstallements(int id) 
	{
		Installements installements = dao.getInstallements(id) ;
		if (installements != null) 
		{
			ResponseStructure<Installements> structure = new ResponseStructure<>() ;
			structure.setMessage("Installements is found...!!");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dao.getInstallements(id));
			return new ResponseEntity<ResponseStructure<Installements>>(structure, HttpStatus.FOUND) ;
		}
		throw new InstallementsIsNotFound("Installements Not found...!!!") ;
	}
	
	public ResponseEntity<ResponseStructure<List<Installements>>> getAllInstallements() 
	{
		List<Installements> list = dao.getAllInstallements() ;
		if(list != null)
		{
			ResponseStructure<List<Installements>> structure = new ResponseStructure<>() ;
			structure.setMessage("All Installements are found..!!");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dao.getAllInstallements());
			return new ResponseEntity<ResponseStructure<List<Installements>>>(structure, HttpStatus.FOUND) ;
		}
		throw new InstallementsIsNotFound("Installements Not found...!!!") ;
	}
	
	public ResponseEntity<ResponseStructure<Installements>> deleteInstallements(int id) 
	{
		Installements installements = dao.getInstallements(id) ;
		if (installements != null) 
		{
			ResponseStructure<Installements> structure = new ResponseStructure<>() ;
			structure.setMessage("Installements is deleted...!");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.deleteInstallements(id));
			return new ResponseEntity<ResponseStructure<Installements>>(structure, HttpStatus.OK) ;
		}
		throw new InstallementsIsNotFound("Installements Not found...!!!") ;
	}
	
	public ResponseEntity<ResponseStructure<Installements>> updateInstallements(int id, Installements installements) 
	{
		Installements dbInstallements = dao.getInstallements(id) ;
		ResponseStructure<Installements> structure = new ResponseStructure<>() ;
		if (dbInstallements != null) 
		{
			structure.setMessage("Installements is updated...!");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.updateInstallements(id, dbInstallements));
			return new ResponseEntity<ResponseStructure<Installements>>(structure, HttpStatus.OK) ;
		}
		throw new InstallementsIsNotFound("Installements Not found...!!!") ;
	}
}
