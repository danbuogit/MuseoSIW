package com.dbaab.museo.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dbaab.museo.model.Artist;
import com.dbaab.museo.model.Painting;
import com.dbaab.museo.service.ArtistService;
import com.dbaab.museo.service.PaintingService;

@Controller
public class PaintingController {
	
	@Autowired
	PaintingService serviceP;
	
	@Autowired
	ArtistService serviceA;
	
	@GetMapping("/admins/painting/add")
	public String retrieveArtistsInfo(Model model)
	{
		List<Artist> artistList = serviceA.findAllOrderedByName();
		model.addAttribute("artistList", artistList);
		model.addAttribute("painting", new Painting());
		return "addPaintingForm";
	}
	
	@PostMapping("/admins/painting/add")
	public String addPainting(@Valid @ModelAttribute Painting painting, BindingResult bindingResult, Model model)
	{
		if(bindingResult.hasErrors())
			return "addPaintingForm";
		else if (!controlYear(painting.getYear())){
			model.addAttribute("errorYear", "Year not valid.");
			return retrieveArtistsInfo(model);
		}
		else{
			model.addAttribute("painting", painting);
			model.addAttribute("isRemoving", false);
			serviceP.save(painting);
		}
		return "summary";
	}

	private boolean controlYear(Integer year)
	{
		
		LocalDate now = LocalDate.now();
		int yearNow = now.getYear();
		
		if(yearNow >= year)
			return true;
		return false;
	}
	
	@GetMapping("/admins/painting/remove")
	public String showInfoPainting(Model model,
			@RequestParam(value="id", required=true) Long id)
	{
		Painting painting = serviceP.findById(id);
		model.addAttribute("painting", painting);
		model.addAttribute("isRemoving", true);
		return "summary";
	}
	
	@PostMapping("/admins/painting/remove")
	public String removePainting(Model model,
			@RequestParam(value="dec", required=true) String decision,
			@RequestParam(value="id", required=true) Long id)
	{
		if(decision.equals("y"))
		{
			this.serviceP.delete(id);
			model.addAttribute("removed", true);
		}
		else
			model.addAttribute("removed", false);
		
		return "redirectionPage";
		
	}
}
