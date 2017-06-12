package com.dbaab.museo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

import com.dbaab.museo.model.Painting;
import com.dbaab.museo.service.PaintingService;

@Controller
public class HomeController {
	
	@Autowired
	PaintingService service;
	
	@GetMapping("/homeController")
	public String getMostRecentPainting(Model model){
		
		List<Painting> listOfThreePainting = service.findFirst3();
		model.addAttribute("listOfThreePainting", listOfThreePainting);
		
		return "home";
	}
}
