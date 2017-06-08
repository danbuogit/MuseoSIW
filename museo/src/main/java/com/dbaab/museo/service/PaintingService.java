package com.dbaab.museo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dbaab.museo.model.Painting;
import com.dbaab.museo.repository.PaintingRepository;

@Service
public class PaintingService {
	
	@Autowired
	PaintingRepository repository;

	@Transactional
	public Painting save(Painting painting){
		return this.repository.save(painting);
	}
	
	public Painting findById(long id){
		return this.repository.findOne(id);
	}
	
	public List<Painting> findAll(){
		return this.repository.findAll();
	}
	
	@Transactional
	public void delete(long id){
		this.repository.delete(id);
	}
	
	@Transactional
	public void delete(Painting painting){
		this.repository.delete(painting);
	}
	
	public List<Painting> findFirstTen(){
		//it can be improved
		return this.repository.findAll().subList(0, 10);
	}
	
	public List<Painting> findFirstTenOrderedBy(String order){
		
		List<Painting> list;
			if(order.equals("artist")){
				list = this.repository.findFirst10ByOrderByArtist();
			}
			else if(order.equals("year")){
				list = this.repository.findFirst10ByOrderByYearAsc();
			}
			else{
				list = this.repository.findFirst10ByOrderByTitle();
			}
			
		return list;
	}
	
	public List<Painting> findFirstThree(){
		//it can be improved
		return this.repository.findAll().subList(0, 3);
	}
}
