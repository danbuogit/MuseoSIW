package com.dbaab.museo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dbaab.museo.model.Artist;
import com.dbaab.museo.service.ArtistService;

@Controller
public class ArtistsPageController
{
    @Autowired
    private ArtistService service;

    @GetMapping("/artistController")
    public String GetArtistList(Model model)
    {
        Iterable<Artist> artists = service.findAllByName();
        model.addAttribute(artists);
        return "artistList";
    }
}
