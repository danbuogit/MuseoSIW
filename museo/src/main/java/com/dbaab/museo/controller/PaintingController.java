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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.dbaab.museo.helpers.RequestHelper;
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
    
    @GetMapping("/admins/painting/modify")
    public String showModifyForm(Model model,
            @RequestParam(value = "id", required = true) Long id,
            @RequestHeader(value = "referer", required = false) final String referer)
    {
        Painting painting = this.paintingService.findById(id);
        if (painting == null)
            return "error";

        List<Artist> artists = artistService.findAllOrderedByName();

        model.addAttribute("ref", referer != null ? referer : "/galleryController");
        model.addAttribute("painting", painting);
        model.addAttribute("artists", artists);
        return "painting-modify";
    }

    @PostMapping("/admins/painting/modify")
    public String modify(Model model,
            @RequestParam(value = "ref", required = true) String referer,
            @Valid @ModelAttribute("painting") Painting painting,
            BindingResult bindingResult)
    {

        if (bindingResult.hasErrors())
        {
            List<Artist> artists = artistService.findAllOrderedByName();
            model.addAttribute("ref", referer);
            model.addAttribute("artists", artists);
            return "painting-modify";
        }

        paintingService.save(painting);

        String redirect = String.format("redirect:%s", RequestHelper.getTemplateFromUrl(referer));
        return redirect;
    }
}
