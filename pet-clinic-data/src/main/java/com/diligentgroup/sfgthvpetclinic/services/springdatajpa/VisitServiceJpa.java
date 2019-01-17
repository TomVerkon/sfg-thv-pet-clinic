package com.diligentgroup.sfgthvpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;

import com.diligentgroup.sfgthvpetclinic.model.Visit;
import com.diligentgroup.sfgthvpetclinic.repositories.VisitRepository;
import com.diligentgroup.sfgthvpetclinic.services.VisitService;

@Profile("springdatajpa")
public class VisitServiceJpa implements VisitService {
	
	private VisitRepository visitRepository;

	public VisitServiceJpa(VisitRepository visitRepository) {
		super();
		this.visitRepository = visitRepository;
	}

	@Override
	public Set<Visit> findAll() {
		Set<Visit> visits = new HashSet<Visit>();
		visitRepository.findAll().forEach(visits::add);
		return visits;
	}

	@Override
	public Visit findById(Long id) {
		return visitRepository.findById(id).orElse(null);
	}

	@Override
	public Visit save(Visit object) {
		return visitRepository.save(object);
	}

	@Override
	public void delete(Visit object) {
		visitRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		visitRepository.deleteById(id);
	}

}
