package com.dbaab.museo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dbaab.museo.model.Painting;
import com.dbaab.museo.service.PaintingService;

@Controller
@RequestMapping("/galleryController")
public class GalleryController
{
    @Autowired
    private PaintingService service;

    @RequestMapping(method = RequestMethod.GET)
    public String getFirstTenPictures(Model model, @RequestParam(value = "order", required = false) String order)
    {
        List<Painting> paintingList;
        
        System.out.println(order);
        
        if (order == null || order.equals("none"))
            paintingList = service.findFirstTen();
        else
            paintingList = service.findFirstTenOrderedBy(order);

        model.addAttribute("paintingList", paintingList);

        return "gallery";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String searchPaintingBy(Model model, @RequestParam(value = "searchBy") String order)
    {
    	//TODO: finire di scrivere metodo
    	
    	return "gallery";
    }
}
