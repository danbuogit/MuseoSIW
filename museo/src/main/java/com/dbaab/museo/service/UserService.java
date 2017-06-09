package com.dbaab.museo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dbaab.museo.model.User;
import com.dbaab.museo.repository.UserRepository;

@Service
public class UserService
{
    @Autowired
    private UserRepository repository;

    public User findById(Long id)
    {
        return this.repository.findOne(id);
    }

    @Transactional
    public User save(User user)
    {
        // If a user with the same username already exists, then do nothing and return null.
        return this.repository.findByUsername(user.getUsername()) == null ? this.repository.save(user) : null;
    }
}
