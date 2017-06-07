package com.dbaab.museo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbaab.museo.model.Admin;
import com.dbaab.museo.repository.AdminRepository;

@Service
public class AdminService
{
	@Autowired
	private AdminRepository repository;
	
	public Admin findById(Long id)
	{
		return this.repository.findOne(id);
	}
	
	public Admin save(Admin admin)
	{
		return this.repository.save(admin);
	}
}
