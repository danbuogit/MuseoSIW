package com.dbaab.museo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Artist
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String surname;

    @NotEmpty
    private String nation;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Past
    private Date birthDate;

    @Temporal(TemporalType.DATE)
    @Past
    private Date deathDate;

    @NotNull
    @OneToMany(mappedBy = "artist")
    @JsonIgnore
    private List<Painting> paintings;

    public Artist()
    {
        this.paintings = new ArrayList<Painting>();
    }
    
    @JsonIgnore
    public String getNameAndSurname()
    {
        return String.format("%s %s", this.name, this.surname);
    }
    
    @Override
    public String toString()
    {
        return String.format("%s %s; born %s, %s %s",
                this.name,
                this.surname,
                this.birthDate.toString(),
                this.nation,
                this.deathDate != null ? String.format("- died %s", this.deathDate.toString()) : "");
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

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public String getNation()
    {
        return nation;
    }

    public void setNation(String nation)
    {
        this.nation = nation;
    }

    public Date getBirthDate()
    {
        return birthDate;
    }

    public void setBirthDate(Date birthDate)
    {
        this.birthDate = birthDate;
    }

    public Date getDeathDate()
    {
        return deathDate;
    }

    public void setDeathDate(Date deathDate)
    {
        this.deathDate = deathDate;
    }

    public List<Painting> getPaintings()
    {
        return paintings;
    }

    public void setPaintings(List<Painting> paintings)
    {
        this.paintings = paintings;
    }
}
