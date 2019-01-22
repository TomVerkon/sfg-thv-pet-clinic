package com.diligentgroup.sfgthvpetclinic.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "pets")
public class Pet extends BaseEntity {

	@Builder
	public Pet(Long id, PetType petType, LocalDate birthDate, String name, Owner owner) {
		super(id);
		this.petType = petType;
		this.birthDate = birthDate;
		this.name = name;
		this.owner = owner;
	}

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
	
	@OneToMany(mappedBy = "pet", cascade = CascadeType.ALL)
	private Set<Visit> visits = new HashSet<Visit>();

}
