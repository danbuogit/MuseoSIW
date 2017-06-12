package com.dbaab.museo.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController
{
    @GetMapping("/login")
    public String showLogin(Principal principal)
    {
        boolean alreadyAuthenticated = principal != null;
        return alreadyAuthenticated ? "redirect:/home" : "login";
    }

    @RequestMapping("/hello")
    public String hello()
    {
        return "hello";
    }
}
