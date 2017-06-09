package com.dbaab.museo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dbaab.museo.model.Artist;

@Repository
public interface ArtistRepository extends CrudRepository<Artist, Long>
{
    List<Artist> findAll();
    List<Artist> findAllByOrderByName();
}
