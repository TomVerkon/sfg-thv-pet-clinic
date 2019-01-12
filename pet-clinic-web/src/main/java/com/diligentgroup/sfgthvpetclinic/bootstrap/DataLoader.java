package com.diligentgroup.sfgthvpetclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.diligentgroup.sfgthvpetclinic.model.Owner;
import com.diligentgroup.sfgthvpetclinic.model.Pet;
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
		owner.setAddress("123 Main St");
		owner.setCity("Roswell");
		owner.setTelephone("770-591-4515");
		Pet pet = new Pet();
		pet.setOwner(owner);
		pet.setName("Fido");
		pet.setPetType(dog);
		pet.setBirthDate(LocalDate.now());
		owner.getPets().add(pet);
		ownerService.save(owner);
		
		owner = new Owner();
		owner.setFirstName("Fiona");
		owner.setLastName("Glenanne");
		owner.setAddress("456 First St");
		owner.setCity("Griffin");
		owner.setTelephone("770-555-1212");
		pet = new Pet();
		pet.setOwner(owner);
		pet.setName("Felix");
		pet.setPetType(cat);
		pet.setBirthDate(LocalDate.now());
		owner.getPets().add(pet);
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
