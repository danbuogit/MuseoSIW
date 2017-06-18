package com.dbaab.museo.service;

import java.util.List;

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

    public List<Artist> findAll()
    {
        return this.repository.findAll();
    }
    
    public List<Artist> findAllOrderedByName()
    {
        return this.repository.findAllByOrderByName();
    }
}
