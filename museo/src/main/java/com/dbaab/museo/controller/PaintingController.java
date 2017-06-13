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
import org.springframework.web.bind.annotation.RequestHeader;

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

    @GetMapping("/admins/painting/add")
    public String showAddForm(Model model, Painting painting)
    {
        List<Artist> artists = artistService.findAllOrderedByName();
        model.addAttribute("artists", artists);
        model.addAttribute("painting", painting);
        return "painting-add";
    }

    @PostMapping("/admins/painting/add")
    public String addPainting(@Valid @ModelAttribute Painting painting, BindingResult bindingResult, Model model)
    {
        if (bindingResult.hasErrors())
            return this.showAddForm(model, painting);

        model.addAttribute("painting", painting);
        model.addAttribute("isRemoving", false);
        paintingService.save(painting);
        return "summary";
    }

    @GetMapping("/admins/painting/remove")
    public String showInfoPainting(Model model, @RequestParam(value = "id", required = true) Long id)
    {
        Painting painting = paintingService.findById(id);
        model.addAttribute("painting", painting);
        model.addAttribute("isRemoving", true);
        return "summary";
    }

    @PostMapping("/admins/painting/remove")
    public String removePainting(Model model,
            @RequestParam(value = "dec", required = true) String decision,
            @RequestParam(value = "id", required = true) Long id)
    {
        if (decision.equals("y"))
        {
            this.paintingService.delete(id);
            model.addAttribute("removed", true);
        }
        else
            model.addAttribute("removed", false);

        return "redirectionPage";

    }

    @GetMapping("/admins/painting/modify")
    public String showModifyForm(Model model,
            @RequestParam(value = "id", required = true) Long id,
            @RequestHeader(value = "referer", required = false) final String referer)
    {
        Painting painting = this.paintingService.findById(id);
        if (painting == null)
            return "error";

        List<Artist> artists = artistService.findAllOrderedByName();

        model.addAttribute("ref", referer != null ? referer : "/gallery");
        model.addAttribute("painting", painting);
        model.addAttribute("artists", artists);
        return "painting-modify";
    }

    @PostMapping("/admins/painting/modify")
    public String modify(Model model, BindingResult bindingResult,
            @RequestParam(value = "ref", required = true) String referer,
            @Valid @ModelAttribute("painting") Painting painting)
    {

        if (bindingResult.hasErrors())
        {
            List<Artist> artists = artistService.findAllOrderedByName();
            model.addAttribute("ref", referer);
            model.addAttribute("artists", artists);
            return "painting-modify";
        }

        paintingService.save(painting);

        String redirect = String.format("redirect:%s", RequestHelper.getControllerFromUrl(referer));
        return redirect;
    }
}