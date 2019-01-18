package com.diligentgroup.sfgthvpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.diligentgroup.sfgthvpetclinic.model.Specialty;
import com.diligentgroup.sfgthvpetclinic.repositories.SpecialtyRepository;
import com.diligentgroup.sfgthvpetclinic.services.SpecialtyService;

@Service
@Profile("springdatajpa")
public class SpecialtyServiceJpa implements SpecialtyService {
	
	private SpecialtyRepository specialtyRepository;

	public SpecialtyServiceJpa(SpecialtyRepository specialtyRepository) {
		super();
		this.specialtyRepository = specialtyRepository;
	}

	@Override
	public Set<Specialty> findAll() {
		Set<Specialty> specialties = new HashSet<Specialty>();
		specialtyRepository.findAll().forEach(specialties::add);
		return specialties;
	}

	@Override
	public Specialty findById(Long id) {
		return specialtyRepository.findById(id).orElse(null);
	}

	@Override
	public Specialty save(Specialty object) {
		return specialtyRepository.save(object);
	}

	@Override
	public void delete(Specialty object) {
		specialtyRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		specialtyRepository.deleteById(id);
	}

}
