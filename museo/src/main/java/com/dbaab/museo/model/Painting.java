package com.dbaab.museo.model;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.hibernate.validator.constraints.NotEmpty;

import com.dbaab.museo.validation.annotations.PastYear;

@Entity
public class Painting
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String title;

    @NotNull
    @PastYear(pastOrPresent = true)
    private Integer year;

    @NotEmpty
    private String technique;

    @NotEmpty
    private String dimensions;

    @Size(max = 500)
    @Column(length = 500)
    private String url;

    @NotNull
    @ManyToOne
    private Artist artist;

    public Painting()
    {}
    
    @Override
    public String toString()
    {
        return String.format("[%s] \"%s\" (%s), %s, %s; technique: %s", (this.id == null ? "null" : this.id), this.title, this.artist.toString(), this.dimensions, this.year, this.technique);
    }

    // GET & SET
    
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public Integer getYear()
    {
        return year;
    }

    public void setYear(Integer year)
    {
        this.year = year;
    }

    public String getTechnique()
    {
        return technique;
    }

    public void setTechnique(String technique)
    {
        this.technique = technique;
    }

    public String getDimensions()
    {
        return dimensions;
    }

    public void setDimensions(String dimensions)
    {
        this.dimensions = dimensions;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public Artist getArtist()
    {
        return artist;
    }

    public void setArtist(Artist artist)
    {
        this.artist = artist;
    }
}
