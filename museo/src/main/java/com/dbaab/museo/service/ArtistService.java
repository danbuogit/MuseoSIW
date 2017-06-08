package com.dbaab.museo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dbaab.museo.model.Artist;
import com.dbaab.museo.repository.ArtistRepository;

@Service
public class ArtistService {
	
	@Autowired
	ArtistRepository repository;
	
	@Transactional
	public Artist save(Artist artist){
		return this.repository.save(artist);
	}
	
	public Artist findOne(long id){
		return this.repository.findOne(id);
	}
	
	public List<Artist> findAll(){
		return this.repository.findAll();
	}
	
	/*we could write: findAllBy(String something){
	*	if(something.equals("name"){
	*		return this.repository.findAllByName();
	*	...
	*	...
	*/
	public List<Artist> findAllByName(){
		return this.repository.findAll();
	}
}