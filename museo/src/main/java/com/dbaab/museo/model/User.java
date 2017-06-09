package com.dbaab.museo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = { "username" }))
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotEmpty
    private String username;

    @NotNull
    @Size(min = 4)
    private String password;
    
    @NotNull
    @ManyToMany
    private List<UserRole> roles;

    public User()
    {
        this.roles = new ArrayList<UserRole>();
    }
    
    public User(String username, String password)
    {
        this();
        this.username = username;
        this.password = password;
    }
    
    public void addRole(UserRole role)
    {
        this.roles.add(role);
    }

    // GET & SET
    
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public List<UserRole> getRoles()
    {
        return roles;
    }
    
    public void setRoles(List<UserRole> roles)
    {
        this.roles = roles;
    }
}
