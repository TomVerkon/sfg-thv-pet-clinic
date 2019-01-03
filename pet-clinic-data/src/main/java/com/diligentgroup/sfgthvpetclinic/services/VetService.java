package com.diligentgroup.sfgthvpetclinic.services;

import java.util.Set;

import com.diligentgroup.sfgthvpetclinic.model.Vet;

public interface VetService {

	Vet findById(Long id);
	
	Vet save(Vet vet);
	
	Set<Vet> findAll();
}
