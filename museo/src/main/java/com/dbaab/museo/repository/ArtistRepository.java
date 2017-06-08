package com.dbaab.museo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dbaab.museo.model.Artist;

public interface ArtistRepository extends CrudRepository<Artist, Long>{
	
	Artist save(Artist artist);
	
	Artist findOne(long id);
	
	List<Artist> findAll();
	
	
}
