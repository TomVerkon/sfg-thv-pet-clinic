package com.diligentgroup.sfgthvpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.diligentgroup.sfgthvpetclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
