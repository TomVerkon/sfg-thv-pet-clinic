package com.diligentgroup.sfgthvpetclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pet_type")
public class PetType extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2481025213761848619L;
	
	
	@Builder
	public PetType(Long id, String name) {
		super(id);
		this.name = name;
	}


	@Column(name = "name")
	private String name;

}
