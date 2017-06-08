package com.dbaab.museo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dbaab.museo.model.Artist;
import com.dbaab.museo.repository.ArtistRepository;

@Service
public class ArtistService
{
    @Autowired
    ArtistRepository repository;

    @Transactional
    public Artist save(Artist artist)
    {
        return this.repository.save(artist);
    }

    public Artist findOne(Long id)
    {
        return this.repository.findOne(id);
    }

    public Iterable<Artist> findAll()
    {
        return this.repository.findAll();
    }

    /* we could write: findAllBy(String something){ if(something.equals("name"){
     * return this.repository.findAllByName(); ... ... */
    public Iterable<Artist> findAllByName()
    {
        return this.repository.findAll();
    }
}
