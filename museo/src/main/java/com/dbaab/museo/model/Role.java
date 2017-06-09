package com.dbaab.museo.model;

public enum Role
{
    USER("USER"),
    ADMIN("ADMIN");
    
    private final String role;
    
    private Role(String role)
    {
        this.role = role;
    }
    
    @Override
    public String toString()
    {
        return this.role;
    }
}
