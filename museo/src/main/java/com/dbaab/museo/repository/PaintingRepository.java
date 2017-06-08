package com.dbaab.museo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dbaab.museo.model.Painting;

public interface PaintingRepository extends CrudRepository<Painting, Long>{
	
	Painting save(Painting painting);
	
	Painting findOne(long id);
	
	List<Painting> findAll();
	
	void delete(long id);
	
	void delete(Painting painting);
}
