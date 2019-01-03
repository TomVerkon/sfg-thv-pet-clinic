package com.diligentgroup.sfgthvpetclinic.services;

import com.diligentgroup.sfgthvpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{
	
	Owner findByLastName(String lastName);
}
