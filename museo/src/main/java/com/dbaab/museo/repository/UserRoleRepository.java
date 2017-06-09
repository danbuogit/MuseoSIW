package com.dbaab.museo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dbaab.museo.model.UserRole;

@Repository
public interface UserRoleRepository extends CrudRepository<UserRole, Integer>
{
    UserRole findByRole(String role);
}
