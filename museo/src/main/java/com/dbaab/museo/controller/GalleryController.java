package com.dbaab.museo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.dbaab.museo.service.PaintingService;

@Controller
public class GalleryController {
	
	@Autowired
	PaintingService service;
	
	//the request shuold have a parameter "orderBy", by default empty
	
	@GetMapping("/galleryController")
	public void GeneratePaintingList(){
		//should call the request, check the "orderBy" and give the list of painting
	}
}
