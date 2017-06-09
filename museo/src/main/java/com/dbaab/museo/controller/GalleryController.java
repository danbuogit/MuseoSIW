package com.dbaab.museo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dbaab.museo.model.Painting;
import com.dbaab.museo.service.PaintingService;

@Controller
public class GalleryController
{
    @Autowired
    private PaintingService service;

    @GetMapping("/galleryController")
    public String getFirstTenPictures(Model model, @RequestParam(value = "order", required = false) String order)
    {
        List<Painting> paintingList;

        if (order == null || order.equals("none"))
            paintingList = service.findFirstTen();
        else
            paintingList = service.findFirstTenOrderedBy(order);

        model.addAttribute("paintingList", paintingList);

        return "gallery";
    }
}
