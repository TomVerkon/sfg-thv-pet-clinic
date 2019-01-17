package com.diligentgroup.sfgthvpetclinic.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "visits")
public class Visit extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -783205217477881233L;
	
	@Column(name = "date")
	private LocalDate date;
	
	@Column(name = "description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "pet_id", referencedColumnName = "id", nullable = false)
	private Pet pet;

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPets(Pet pet) {
		this.pet = pet;
	}
}
