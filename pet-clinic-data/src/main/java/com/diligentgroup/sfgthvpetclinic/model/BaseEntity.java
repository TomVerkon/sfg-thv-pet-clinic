package com.diligentgroup.sfgthvpetclinic.model;

import java.io.Serializable;

public class BaseEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2447015896752663230L;
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

}
