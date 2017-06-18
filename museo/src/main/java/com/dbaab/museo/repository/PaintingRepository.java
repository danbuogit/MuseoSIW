package com.dbaab.museo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dbaab.museo.model.Painting;

@Repository
public interface PaintingRepository extends CrudRepository<Painting, Long>, PagingAndSortingRepository<Painting, Long>
{
    List<Painting> findAll();
    List<Painting> findFirst3By();
    List<Painting> findFirst10By();
    List<Painting> findFirst10ByOrderByTitle();
    List<Painting> findFirst10ByOrderByYearAsc();
    List<Painting> findFirst10ByOrderByYearDesc();
    List<Painting> findFirst10ByOrderByArtistName();
    List<Painting> findFirst10ByOrderByArtistSurname();
    Page<Painting> findFirst10ByArtistId(long id, Pageable pageable);
}
