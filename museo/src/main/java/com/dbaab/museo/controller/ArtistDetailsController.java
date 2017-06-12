package com.dbaab.museo.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dbaab.museo.model.Artist;
import com.dbaab.museo.service.ArtistService;

@Controller
@RequestMapping("/artistDetailsController")
public class ArtistDetailsController {
	
	@Autowired
	private ArtistService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public String RetriveAllInfo(Model model, @RequestParam(value = "painter") Long painter )
	{
		Artist artist = service.findOne(painter);
		model.addAttribute("artist", artist);
		return "artistDetails";
	}
}
