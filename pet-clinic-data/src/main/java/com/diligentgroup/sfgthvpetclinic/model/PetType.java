package com.diligentgroup.sfgthvpetclinic.model;

import lombok.ToString;

public class PetType extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2481025213761848619L;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
