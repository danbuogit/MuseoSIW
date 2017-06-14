package com.dbaab.museo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactsController {
	
	@GetMapping("/contacts")
	public String redirect(){
		return "contactsPage";
	}
}
