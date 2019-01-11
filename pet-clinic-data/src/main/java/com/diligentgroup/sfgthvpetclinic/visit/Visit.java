package com.diligentgroup.sfgthvpetclinic.visit;

import java.time.LocalDate;

import com.diligentgroup.sfgthvpetclinic.model.BaseEntity;
import com.diligentgroup.sfgthvpetclinic.model.Pet;

public class Visit extends BaseEntity {

	private LocalDate date;
	private String description;
	private Pet pets;

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

	public Pet getPets() {
		return pets;
	}

	public void setPets(Pet pets) {
		this.pets = pets;
	}
}
