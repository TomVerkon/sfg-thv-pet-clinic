package com.diligentgroup.sfgthvpetclinic.model;

import java.time.LocalDate;

import lombok.ToString;

public class Pet extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9105633380730822807L;
	private PetType petType;
	private Owner owner;
	private LocalDate birthDate;
	private String name;

	public PetType getPetType() {
		return petType;
	}

	public void setPetType(PetType petType) {
		this.petType = petType;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
