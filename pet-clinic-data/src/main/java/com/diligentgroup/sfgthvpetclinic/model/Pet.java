package com.diligentgroup.sfgthvpetclinic.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pets")
public class Pet extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9105633380730822807L;
	
	// @ManyToOne Many pets may have the same pet type
	// @JoinColumn(name = "pet_type_id") Names the ForeignKey column in the pets table as pet_type_id. 
	// Therefore the @Column(name = "<columnName>") annotation is not allowed on @ManyToOne relationships
	@ManyToOne
	@JoinColumn(name = "pet_type_id", nullable = false)
	private PetType petType;
	
	// @ManyToOne Many pets may have the same owner
	// @JoinColumn(name = "owner_id") Names the ForeignKey column in the pets table as owner_id. 
	// Therefore the @Column(name = "<columnName>") annotation is not allowed on @ManyToOne relationships
	@ManyToOne
	@JoinColumn(name = "owner_id", nullable = false)
	private Owner owner;
	
	@Column(name = "birth_date")
	private LocalDate birthDate;
	
	@Column(name = "name")
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
