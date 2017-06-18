package com.dbaab.museo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dbaab.museo.model.Painting;
import com.dbaab.museo.service.PaintingService;

@RestController
public class PaintingRestController
{
    @Autowired
    private PaintingService paintingService;

    /**
     * Get a painting.
     * @param id - the Painting's id.
     * @return a painting.
     */
    @GetMapping("/api/painting/{id}")
    public Painting getPainting(@PathVariable("id") Long id)
    {
        Painting painting = paintingService.findById(id);
        return painting;
    }

    /**
     * Get all paintings.
     * @return a list of paintings.
     */
    @GetMapping("/api/paintings")
    public List<Painting> getPaintings()
    {
        List<Painting> paintings = paintingService.findAll();
        return paintings;
    }
}
