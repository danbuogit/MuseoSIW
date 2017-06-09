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

    public List<Painting> findFirstTenOrderedBy(String order)
    {
        List<Painting> list = null;
        if (order.equals("artist"))
            list = this.repository.findFirst10ByOrderByArtist();
        else if (order.equals("year"))
            list = this.repository.findFirst10ByOrderByYearAsc();
        else if (order.equals("title"))
            list = this.repository.findFirst10ByOrderByTitle();

        return list;
    }

    public List<Painting> findFirstThree()
    {
        // TODO: Improve
        return this.repository.findAll().subList(0, 3);
    }

    public List<Painting> findFirstTen()
    {
        // TODO: Improve
        return this.repository.findAll().subList(0, 10);
    }
}
