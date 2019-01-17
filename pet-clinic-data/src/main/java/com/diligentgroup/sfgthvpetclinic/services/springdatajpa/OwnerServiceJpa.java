package com.diligentgroup.sfgthvpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.diligentgroup.sfgthvpetclinic.model.Owner;
import com.diligentgroup.sfgthvpetclinic.repositories.OwnerRepository;
import com.diligentgroup.sfgthvpetclinic.services.OwnerService;

@Service
@Profile("springdatajpa")
public class OwnerServiceJpa implements OwnerService {
	
	private final OwnerRepository ownerRepository;
	
	public OwnerServiceJpa(OwnerRepository ownerRepository) {
		super();
		this.ownerRepository = ownerRepository;
	}

	@Override
	public Set<Owner> findAll() {
		Set<Owner> owners = new HashSet<Owner>();
		ownerRepository.findAll().forEach(owners::add);
		return owners;
	}

	@Override
	public Owner findById(Long id) {
		return ownerRepository.findById(id).orElse(null);
	}

	@Override
	public Owner save(Owner object) {
		return ownerRepository.save(object);
	}

	@Override
	public void delete(Owner object) {
		ownerRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		ownerRepository.deleteById(id);
	}

	@Override
	public Owner findByLastName(String lastName) {
		return ownerRepository.findByLastName(lastName);
	}

}
