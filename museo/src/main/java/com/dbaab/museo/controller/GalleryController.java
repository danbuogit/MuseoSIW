package com.dbaab.museo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @RequestMapping(method = RequestMethod.GET, value = { "galleryController", "galleryController/{order}" })
    public String getFirstTenPictures(Model model, @RequestParam(value = "order", required = false) String order,
            @PathVariable("order") String order2)
    {
        Iterable<Painting> paintingList;

        if (order == null)
            paintingList = service.findFirstTen();
        else
            paintingList = service.findFirstTenOrderedBy(order2);

        model.addAttribute(paintingList);

        return "gallery";
    }
}
