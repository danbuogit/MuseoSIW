package com.dbaab.museo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dbaab.museo.model.Painting;

@Repository
public interface PaintingRepository extends CrudRepository<Painting, Long>{
	
	Painting save(Painting painting);
	
	Painting findOne(long id);
	
	List<Painting> findAll();
	
	void delete(long id);
	
	void delete(Painting painting);
	
	List<Painting> findFirst10ByOrderByTitle();
	
	List<Painting> findFirst10ByOrderByYear();
	
	List<Painting> findFirst10ByOrderByArtist();
}
