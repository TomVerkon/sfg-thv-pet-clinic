package com.diligentgroup.sfgthvpetclinic.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.diligentgroup.sfgthvpetclinic.model.Specialty;
import com.diligentgroup.sfgthvpetclinic.model.Vet;
import com.diligentgroup.sfgthvpetclinic.services.SpecialtyService;
import com.diligentgroup.sfgthvpetclinic.services.VetService;

@Service
@Profile({"default", "map"})
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

	private SpecialtyService specialtyService;

	public VetServiceMap(SpecialtyService specialtyService) {
		super();
		this.specialtyService = specialtyService;
	}

	@Override
	public Vet findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Vet save(Vet vet) {
		if (vet != null) {
			if (!CollectionUtils.isEmpty(vet.getSpecialties())) {
				vet.getSpecialties().forEach(specialty -> {
					if (specialty.getId() == null) {
						Specialty savedSpecailty = specialtyService.save(specialty);
						specialty.setId(savedSpecailty.getId());
					}
				});
			}
			return super.save(vet);
		} else {
			// passed vet is null
			return vet;
		}
	}

	@Override
	public Set<Vet> findAll() {
		return super.findAll();
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
