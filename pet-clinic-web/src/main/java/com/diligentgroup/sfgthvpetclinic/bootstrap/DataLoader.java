package com.diligentgroup.sfgthvpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.diligentgroup.sfgthvpetclinic.model.Owner;
import com.diligentgroup.sfgthvpetclinic.model.PetType;
import com.diligentgroup.sfgthvpetclinic.model.Vet;
import com.diligentgroup.sfgthvpetclinic.services.OwnerService;
import com.diligentgroup.sfgthvpetclinic.services.PetTypeService;
import com.diligentgroup.sfgthvpetclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;

	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
		super();
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
	}

	@Override
	public void run(String... args) throws Exception {
		
		PetType dog = new PetType();
		dog.setName("Dog");
		dog = petTypeService.save(dog);
		
		PetType cat = new PetType();
		cat.setName("Cat");
		cat = petTypeService.save(cat);
		
		System.out.println("PetTypes loaded!");
		
		Owner owner = new Owner();
		owner.setFirstName("Michael");
		owner.setLastName("Weston");
		ownerService.save(owner);
		
		owner = new Owner();
		owner.setFirstName("Fiona");
		owner.setLastName("Glenanne");
		ownerService.save(owner);
		
		System.out.println("Owners loaded!");
		
		Vet vet = new Vet();
		vet.setFirstName("Sam");
		vet.setLastName("Axe");
		vetService.save(vet);
		
		vet = new Vet();
		vet.setFirstName("Tom");
		vet.setLastName("Lemay");
		vetService.save(vet);
		
		System.out.println("Vets loaded!");
		
	}

}
