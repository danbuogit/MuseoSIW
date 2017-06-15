package com.dbaab.museo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dbaab.museo.model.Artist;
import com.dbaab.museo.service.ArtistService;

@Controller
public class ArtistController
{
    @Autowired
    private ArtistService service;

    @GetMapping("/artists")
    public String showArtistsList(Model model)
    {
        List<Artist> listArtists = service.findAllOrderedByName();
        model.addAttribute("artistList", listArtists);
        return "artists";
    }

    @GetMapping("/artist")
    public String showArtistDetails(Model model, @RequestParam(value = "id") Long id)
    {
        Artist artist = service.findOne(id);
        model.addAttribute("artist", artist);
        return "artist-details";
    }
}
