package com.diligentgroup.sfgthvpetclinic.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "vets")
public class Vet extends Person {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2346089693183540530L;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "vet_specialties",
			joinColumns = @JoinColumn(name = "vet_id"), 
			inverseJoinColumns = @JoinColumn(name = "specialty_id"))
	private Set<Specialty> specialties;

	public Set<Specialty> getSpecialties() {
		if (this.specialties == null) {
			this.specialties = new HashSet<Specialty>();
		}
		return specialties;
	}

	public void setSpecialties(Set<Specialty> specialties) {
		this.specialties = specialties;
	}

}
