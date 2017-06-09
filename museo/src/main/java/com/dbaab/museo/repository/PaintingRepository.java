package com.dbaab.museo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dbaab.museo.model.Painting;

@Repository
public interface PaintingRepository extends CrudRepository<Painting, Long>
{
    List<Painting> findAll();
    List<Painting> findFirst3By();
    List<Painting> findFirst10By();
    List<Painting> findFirst10ByOrderByTitle();
    List<Painting> findFirst10ByOrderByYear();
    List<Painting> findFirst10ByOrderByArtist();
}
