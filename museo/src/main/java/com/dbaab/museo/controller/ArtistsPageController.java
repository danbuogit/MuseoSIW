package com.dbaab.museo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dbaab.museo.model.Artist;
import com.dbaab.museo.service.ArtistService;

@Controller
public class ArtistsPageController {
	
	@Autowired
	ArtistService service;
	
	@GetMapping("/artistController")
	public String getArtistList(Model model){
		
		List<Artist> listArtists = service.findAllOrderByName();
		model.addAttribute(listArtists);
		return "artistList";
	}
}
