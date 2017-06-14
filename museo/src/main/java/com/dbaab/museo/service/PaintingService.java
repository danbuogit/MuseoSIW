package com.dbaab.museo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    public List<Painting> findFirst3()
    {
        return this.repository.findFirst3By();
    }

    public List<Painting> findFirst10()
    {
        return this.repository.findFirst10By();
    }
    
    public Page<Painting> findFirst10AtPage(int pageIndex)
    {
    	Page<Painting> paintings = this.repository.findAll(goToPage(pageIndex));
    	return paintings;
    }
    
    public Page<Painting> findFirst10AtPage(int pageIndex, String order)
    {
    	Page<Painting> painting = this.repository.findAll(goToPage(pageIndex, order));
    	return painting;
    }
    
    private PageRequest goToPage(int pageIndex)
    {
    	return (new PageRequest(pageIndex, 10));
    }
    
    private PageRequest goToPage(int pageIndex, String order)
    {
    	 if (order.equals("artistName"))
             return (new PageRequest(pageIndex, 10, Sort.Direction.ASC, "artistName"));
         if (order.equals("artistSurname"))
         	return (new PageRequest(pageIndex, 10, Sort.Direction.ASC, "artistSurname"));
         if (order.equals("yearAsc"))
             return (new PageRequest(pageIndex, 10, Sort.Direction.ASC, "Year"));
         if (order.equals("yearDesc"))
         	return (new PageRequest(pageIndex, 10, Sort.Direction.DESC, "Year"));
         return (new PageRequest(pageIndex, 10, Sort.Direction.ASC, "Title"));
    }
}
