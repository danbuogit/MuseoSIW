package com.dbaab.museo.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
public class Artist {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotNull
	private String name;
	
	@NotNull
	private String surname;
	
	@NotNull
	private String nation;
	
	@NotNull
	private Date birthDate;
	
	private Date deathDate;
	
	@NotNull
	@OneToMany(mappedBy="artist")
	private List<Painting> paintings;
	
	public Artist() { }
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Date getDeathDate() {
		return deathDate;
	}

	public void setDeathDate(Date deathDate) {
		this.deathDate = deathDate;
	}

	public List<Painting> getPaintings() {
		return paintings;
	}

	public void setPaintings(List<Painting> paintings) {
		this.paintings = paintings;
	}
	
	
}
