package com.diligentgroup.sfgthvpetclinic.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.diligentgroup.sfgthvpetclinic.model.Visit;
import com.diligentgroup.sfgthvpetclinic.services.VisitService;

@Service
@Profile({"default", "map"})
public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService{
	
	

	@Override
	public Set<Visit> findAll() {
		return super.findAll();
	}

	@Override
	public Visit findById(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public Visit save(Visit visit) {
		if (visit.getPet() == null 
				|| visit.getPet().isNew() 
				|| visit.getPet().getOwner() == null 
				|| visit.getPet().getOwner().isNew()) {
			throw new RuntimeException("Invalid Visit, missing or unpersisted Pet or Pet Owner!");
		} else 
		return super.save(visit);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		super.deleteById(id);
	}

	@Override
	public void delete(Visit object) {
		// TODO Auto-generated method stub
		super.delete(object);
	}

}
