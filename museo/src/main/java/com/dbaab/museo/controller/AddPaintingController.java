package com.dbaab.museo.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dbaab.museo.model.Artist;
import com.dbaab.museo.model.Painting;
import com.dbaab.museo.service.ArtistService;
import com.dbaab.museo.service.PaintingService;

@Controller
@RequestMapping("/addPaintingController")
public class AddPaintingController {
	
	@Autowired
	PaintingService serviceP;
	@Autowired
	ArtistService serviceA;
	
	@RequestMapping(method = RequestMethod.GET)
	public String retrieveArtistsInfo(Model model)
	{
		List<Artist> artistList = serviceA.findAllOrderedByName();
		model.addAttribute("artistList", artistList);
		model.addAttribute("painting", new Painting());
		return "addPaintingForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String addPainting(@Valid @ModelAttribute Painting painting, BindingResult bindingResult, Model model)
	{
		if(bindingResult.hasErrors())
			return "addPaintingForm";
		else if (!controllYear(painting.getYear())){
			model.addAttribute("errorYear", "Year not valid.");
			return retrieveArtistsInfo(model);
		}
		else{
			model.addAttribute("newPainting", painting);
			serviceP.save(painting);
		}
		return "summary";
	}

	private boolean controllYear(Integer year) {
		
		LocalDate now = LocalDate.now();
		int yearNow = now.getYear();
		
		if(yearNow >= year)
			return true;
		return false;
	}
}
