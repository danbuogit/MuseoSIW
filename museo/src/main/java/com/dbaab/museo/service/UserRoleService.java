package com.dbaab.museo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dbaab.museo.model.UserRole;
import com.dbaab.museo.repository.UserRoleRepository;

@Service
public class UserRoleService
{
    @Autowired
    private UserRoleRepository repository;

    /** Retrieves a UserRole entity by its role name.
     * @param role - the role name
     * @return the retrieved UserRole */
    public UserRole findByRole(String role)
    {
        return this.repository.findByRole(role);
    }

    /** Retrieves a UserRole entity by its role name or creates it, if it does not exist.
     * @param role - the role name
     * @return the retrieved or created UserRole */
    @Transactional
    public UserRole findByRoleOrCreate(String role)
    {
        UserRole userRole = this.repository.findByRole(role);
        if (userRole == null)
            userRole = this.save(new UserRole(role));
        return userRole;
    }
    
    @Transactional
    public UserRole save(UserRole role)
    {
        return this.repository.save(role);
    }
}
