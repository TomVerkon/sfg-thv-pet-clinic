package com.diligentgroup.sfgthvpetclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.diligentgroup.sfgthvpetclinic.model.Pet;
import com.diligentgroup.sfgthvpetclinic.services.PetService;

@Service
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {

	@Override
	public Pet findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Pet save(Pet pet) {
		return super.save(pet);
	}

	@Override
	public Set<Pet> findAll() {
		return super.findAll();
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(Pet pet) {
		super.delete(pet);
	}

}
