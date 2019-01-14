package com.diligentgroup.sfgthvpetclinic.model;

import lombok.ToString;

public class Specialty extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8574153354221522230L;
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
