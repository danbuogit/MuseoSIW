package com.dbaab.museo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController
{
    @GetMapping("/login")
    public String showLogin()
    {
        return "login";
    }
    
    @RequestMapping("/hello")
    public String hello()
    {
        return "hello";
    }
}
