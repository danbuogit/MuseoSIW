package com.dbaab.museo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbaab.museo.model.Painting;
import com.dbaab.museo.repository.PaintingRepository;

@Service
public class PaintingService {
	
	@Autowired
	PaintingRepository repository;
	
	public Painting findById(long id){
		return this.repository.findOne(id);
	}
	
	public Painting save(Painting painting){
		return this.repository.save(painting);
	}
	
	public List<Painting> findAll(){
		return this.repository.findAll();
	}
	
	public void delete(long id){
		this.repository.delete(id);
	}
	
	public void delete(Painting painting){
		this.repository.delete(painting);
	}
	
	public List<Painting> findFirstTen(){
		//it can be improved
		return this.repository.findAll().subList(0, 9);
	}
	
	public List<Painting> findFirstThree(){
		//it can be improved
		return this.repository.findAll().subList(0, 2);
	}
}
