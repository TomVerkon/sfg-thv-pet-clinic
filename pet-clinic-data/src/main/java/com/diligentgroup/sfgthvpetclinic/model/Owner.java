package com.diligentgroup.sfgthvpetclinic.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "owners")
public class Owner extends Person {

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
    private Set<Pet> pets;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Set<Pet> getPets() {
		if (pets == null) {
			pets = new HashSet<Pet>();
		}
		return pets;
	}

	public void setPets(Set<Pet> pets) {
		this.pets = pets;
	}

}
