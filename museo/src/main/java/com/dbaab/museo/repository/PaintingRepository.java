package com.dbaab.museo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.dbaab.museo.model.Painting;

@Repository
public interface PaintingRepository extends CrudRepository<Painting, Long>, PagingAndSortingRepository<Painting, Long>
{
    List<Painting> findAll();
    List<Painting> findByArtistId(Long id);
    List<Painting> findFirst3By();
    Page<Painting> findFirst10ByArtistId(long id, Pageable pageable);
}
