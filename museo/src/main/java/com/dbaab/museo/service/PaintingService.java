package com.dbaab.museo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dbaab.museo.model.Painting;
import com.dbaab.museo.repository.PaintingRepository;

@Service
public class PaintingService
{
    @Autowired
    private PaintingRepository repository;

    public Painting findById(Long id)
    {
        return this.repository.findOne(id);
    }

    @Transactional
    public Painting save(Painting painting)
    {
        return this.repository.save(painting);
    }

    public List<Painting> findAll()
    {
        return this.repository.findAll();
    }

    @Transactional
    public void delete(Long id)
    {
        this.repository.delete(id);
    }

    @Transactional
    public void delete(Painting painting)
    {
        this.repository.delete(painting);
    }

    public List<Painting> findFirst10OrderedBy(String order)
    {
        List<Painting> list = null;

        if (order.equals("artistName"))
            list = this.repository.findFirst10ByOrderByArtistName();
        else if (order.equals("artistSurname"))
        	list = this.repository.findFirst10ByOrderByArtistSurname();
        else if (order.equals("yearAsc"))
            list = this.repository.findFirst10ByOrderByYearAsc();
        else if (order.equals("yearDesc"))
        	list= this.repository.findFirst10ByOrderByYearDesc();
        else if (order.equals("title"))
            list = this.repository.findFirst10ByOrderByTitle();
        else
            list = this.findFirst10();

        return list;
    }

    public List<Painting> findFirst3()
    {
        return this.repository.findFirst3By();
    }

    public List<Painting> findFirst10()
    {
        return this.repository.findFirst10By();
    }
}
