package com.diligentgroup.sfgthvpetclinic.model;

import java.util.HashSet;
import java.util.Set;

import lombok.ToString;

@ToString
public class Vet extends Person {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2346089693183540530L;
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
