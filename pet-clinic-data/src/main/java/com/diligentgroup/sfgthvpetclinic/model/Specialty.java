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
@Table(name = "specialties")
public class Specialty extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8574153354221522230L;

	@Builder
	public Specialty(Long id, String description) {
		super(id);
		this.description = description;
	}

	@Column(name = "description")
	private String description;

}
