package com.dbaab.museo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dbaab.museo.model.Painting;
import com.dbaab.museo.service.PaintingService;

@Controller
@RequestMapping("/gallery")
public class GalleryController
{
    @Autowired
    private PaintingService service;

    @RequestMapping(method = RequestMethod.GET)
    public String getFirstTenPictures(Model model,
            @RequestParam(value = "order", required = false) String order,
            @RequestParam(value = "page", required = false) String page)
    {
        Page<Painting> paintingList;

        if (page == null)
            page = "0";

        int pageIndex = Integer.parseInt(page);

        if (order == null || order.equals("none"))
        {
            paintingList = service.findFirst10AtPage(pageIndex);
            order = "none";
        }
        else
            paintingList = service.findFirst10AtPage(pageIndex, order);

        model.addAttribute("paintingList", paintingList);
        // used for page management
        model.addAttribute("order", order);
        model.addAttribute("page", pageIndex);
        model.addAttribute("hasNext", paintingList.hasNext());

        return "gallery";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String searchPaintingBy(Model model, @RequestParam(value = "searchBy") String order)
    {
        // TODO: finire di scrivere metodo

        return "gallery";
    }
}
