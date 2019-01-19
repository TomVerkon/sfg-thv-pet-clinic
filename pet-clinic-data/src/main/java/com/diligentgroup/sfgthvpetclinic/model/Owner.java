package com.diligentgroup.sfgthvpetclinic.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "owners")
public class Owner extends Person {

	@Builder
	public Owner(String firstName, String lastName, String address, String city, String telephone) {
		super(firstName, lastName);
		this.address = address;
		this.city = city;
		this.telephone = telephone;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 7062089765105750509L;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "city")
    private String city;
	
	@Column(name = "telephone")
    private String telephone;
	
	// @OneToMany One owner may have many pets
	// Cascade=All includes PERSIST, MERGE, REMOVE, REFRESH, DETACH
	// mappedBy="owner" field name of Owner Object in Pet
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<Pet>();
	
	public void addPet(Pet pet) {
		pets.add(pet);
	}

	}
