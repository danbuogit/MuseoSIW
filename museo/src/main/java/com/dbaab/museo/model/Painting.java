package com.dbaab.museo.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Painting
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String title;

    @NotNull
    private Integer year;

    @NotNull
    private String tecnique;

    @NotNull
    private String dimensions;

    @NotNull
    @Size(max = 500)
    @Column(length = 500)
    private String url;

    @NotNull
    @ManyToOne
    private Artist artist;

    public Painting()
    {}

    // GET & SET
    
    public long getId()
    {
        return id;
    }

    public void setId(long id)
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

    public String getTecnique()
    {
        return tecnique;
    }

    public void setTecnique(String tecnique)
    {
        this.tecnique = tecnique;
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
