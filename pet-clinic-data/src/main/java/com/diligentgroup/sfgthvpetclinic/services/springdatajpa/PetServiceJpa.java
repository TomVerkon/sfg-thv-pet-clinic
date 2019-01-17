package com.diligentgroup.sfgthvpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;

import com.diligentgroup.sfgthvpetclinic.model.Pet;
import com.diligentgroup.sfgthvpetclinic.repositories.PetRepository;
import com.diligentgroup.sfgthvpetclinic.services.PetService;

@Profile("springdatajpa")
public class PetServiceJpa implements PetService {
	
	private PetRepository petRepository;

	public PetServiceJpa(PetRepository petRepository) {
		super();
		this.petRepository = petRepository;
	}

	@Override
	public Set<Pet> findAll() {
		Set<Pet> pets = new HashSet<Pet>();
 		petRepository.findAll().forEach(pets::add);
 		return pets;
	}

	@Override
	public Pet findById(Long id) {
		return petRepository.findById(id).orElse(null);
	}

	@Override
	public Pet save(Pet object) {
		return petRepository.save(object);
	}

	@Override
	public void delete(Pet object) {
		petRepository.delete(object);		
	}

	@Override
	public void deleteById(Long id) {
		petRepository.deleteById(id);		
	}

}
