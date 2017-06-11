package com.dbaab.museo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dbaab.museo.model.Artist;
import com.dbaab.museo.model.Painting;
import com.dbaab.museo.service.ArtistService;
import com.dbaab.museo.service.PaintingService;

@Controller
public class PaintingController
{
    @Autowired
    private PaintingService paintingService;
    
    @Autowired
    private ArtistService artistService;
    
    @GetMapping("/painting/modify")
    public String showModifyForm(Model model, @RequestParam(value = "id", required = true) Long id)
    {
        Painting painting = this.paintingService.findById(id);
        if (painting == null)
            return "error";
        
        List<Artist> artists = artistService.findAllOrderedByName();
        
        model.addAttribute("painting", painting);
        model.addAttribute("artists", artists);
        return "painting-modify";
    }

    @PostMapping("/painting/modify")
    public String modify(@Valid @ModelAttribute("painting") Painting painting, BindingResult bindingResult, Model model)
    {
        if (bindingResult.hasErrors())
        {
            List<Artist> artists = artistService.findAllOrderedByName();
            model.addAttribute("artists", artists);
            return "painting-modify";
        }
        
        System.out.println(painting.toString());
        paintingService.save(painting);
        return "painting-modify";
    }
}
