package com.diligentgroup.sfgthvpetclinic.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.diligentgroup.sfgthvpetclinic.model.Owner;
import com.diligentgroup.sfgthvpetclinic.services.OwnerService;
import com.diligentgroup.sfgthvpetclinic.services.PetService;
import com.diligentgroup.sfgthvpetclinic.services.PetTypeService;

@Service
@Profile({"default", "map"})
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {
	
	private PetService petService;
	private PetTypeService petTypeService;
	
	

	public OwnerServiceMap(PetService petService, PetTypeService petTypeService) {
		super();
		this.petService = petService;
		this.petTypeService = petTypeService;
	}

	@Override
	public Owner findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Set<Owner> findAll() {
		return super.findAll();
	}

	@Override
	public Owner save(Owner owner) {
		if (owner != null) {
			if (!CollectionUtils.isEmpty(owner.getPets())) {
				owner.getPets().forEach(pet -> {
					if (pet.getPetType() != null) {
						if (pet.getPetType().getId() == null) {
							pet.setPetType(petTypeService.save(pet.getPetType()) );
						}
					} else {
						throw new RuntimeException("PetType is required!");
					}
					if (pet.getId() == null) {
						pet.setId((petService.save(pet)).getId());
					}
				});
			}
			return super.save(owner);
		} else {
			// passed owner is null
			return owner;
		}		
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(Owner object) {
		super.delete(object);
	}

	@Override
	public Owner findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

}
