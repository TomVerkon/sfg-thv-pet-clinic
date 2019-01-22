package com.diligentgroup.sfgthvpetclinic.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "vets")
public class Vet extends Person {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2346089693183540530L;
	
	@Builder
	public Vet(Long id, String firstName, String lastName) {
		super(id, firstName, lastName);
	}
	
	public Vet() {}
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "vet_specialties",
			joinColumns = @JoinColumn(name = "vet_id"), 
			inverseJoinColumns = @JoinColumn(name = "specialty_id"))
	private Set<Specialty> specialties = new HashSet<Specialty>();

	public void addSpecialty(Specialty specialty) {
		specialties.add(specialty);
	}

}
