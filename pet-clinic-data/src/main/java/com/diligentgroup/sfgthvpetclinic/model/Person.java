package com.diligentgroup.sfgthvpetclinic.model;

import lombok.ToString;

public class Person  extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3133750493301081164L;
	private String firstName;
	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
