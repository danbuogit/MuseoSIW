package com.dbaab.museo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dbaab.museo.model.Admin;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Long>
{
		Admin save(Admin admin);
		
		Admin findOne(Long id);
		
		
}
