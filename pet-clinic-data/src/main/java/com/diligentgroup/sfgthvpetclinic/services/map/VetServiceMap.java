package com.diligentgroup.sfgthvpetclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.diligentgroup.sfgthvpetclinic.model.Vet;
import com.diligentgroup.sfgthvpetclinic.services.VetService;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

	@Override
	public Vet findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Vet save(Vet vet) {
		return super.save(vet.getId(), vet);
	}

	@Override
	public Set<Vet> findAll() {
		return super.findAll();
	}

	@Override
	Vet save(Long id, Vet vet) {
		return super.save(id, vet);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(Vet object) {
		super.delete(object);
	}

}
