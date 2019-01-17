package com.diligentgroup.sfgthvpetclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pet_type")
public class PetType extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2481025213761848619L;
	@Column(name = "name")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
