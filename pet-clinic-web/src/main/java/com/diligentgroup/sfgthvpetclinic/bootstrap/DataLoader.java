package com.diligentgroup.sfgthvpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.diligentgroup.sfgthvpetclinic.model.Owner;
import com.diligentgroup.sfgthvpetclinic.model.Vet;
import com.diligentgroup.sfgthvpetclinic.services.OwnerService;
import com.diligentgroup.sfgthvpetclinic.services.VetService;
import com.diligentgroup.sfgthvpetclinic.services.map.OwnerServiceMap;
import com.diligentgroup.sfgthvpetclinic.services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;

	public DataLoader(OwnerService ownerService, VetService vetService) {
		super();
		this.ownerService = ownerService;
		this.vetService = vetService;
	}

	@Override
	public void run(String... args) throws Exception {

		Owner owner = new Owner();
		owner.setId(1L);
		owner.setFirstName("Michael");
		owner.setLastName("Weston");
		ownerService.save(owner);
		
		owner = new Owner();
		owner.setId(2L);
		owner.setFirstName("Fiona");
		owner.setLastName("Glenanne");
		ownerService.save(owner);
		ownerService.save(owner);
		
		System.out.println("Owners loaded!");
		
		Vet vet = new Vet();
		vet.setId(1L);
		vet.setFirstName("Sam");
		vet.setLastName("Axe");
		vetService.save(vet);
		
		vet = new Vet();
		vet.setId(2L);
		vet.setFirstName("Tom");
		vet.setLastName("Lemay");
		vetService.save(vet);
		
		System.out.println("Vets loaded!");
		
	}

}
