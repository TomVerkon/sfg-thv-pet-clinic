package com.diligentgroup.sfgthvpetclinic.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@MappedSuperclass
public class Person extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3133750493301081164L;
	
	public Person(Long id, String firstName, String lastName) {
		super(id);
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;

}
