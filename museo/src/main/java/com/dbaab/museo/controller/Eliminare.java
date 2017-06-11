package com.dbaab.museo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Eliminare {
	
	@GetMapping("/commands")
	public String getCommands(){
		return "commands";
	}
	
}
