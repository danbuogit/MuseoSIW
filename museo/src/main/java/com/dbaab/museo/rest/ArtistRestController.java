package com.dbaab.museo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dbaab.museo.model.Artist;
import com.dbaab.museo.model.Painting;
import com.dbaab.museo.service.ArtistService;

@RestController
public class ArtistRestController
{
    @Autowired
    private ArtistService artistService;

    /**
     * Get all artists.
     * @return a list of artists.
     */
    @GetMapping("/api/artists")
    public List<Artist> getArtists()
    {
        List<Artist> artists = this.artistService.findAll();
        return artists;
    }

    /**
     * Get an artist.
     * @param id - the Artist's id.
     * @return an artist.
     */
    @GetMapping("/api/artist/{id}")
    public Artist getArtist(@PathVariable("id") Long id)
    {
        Artist artist = this.artistService.findOne(id);
        return artist;
    }

    /**
     * Get an artist's paintings.
     * @param id - the Artist's id.
     * @return a list of paintings.
     */
    @GetMapping("/api/artist/{id}/paintings")
    public List<Painting> getPaintings(@PathVariable("id") Long id)
    {
        Artist artist = this.artistService.findOne(id);
        return artist.getPaintings();
    }
}
