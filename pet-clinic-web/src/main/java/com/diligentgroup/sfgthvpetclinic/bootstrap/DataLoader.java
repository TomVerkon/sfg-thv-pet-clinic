package com.diligentgroup.sfgthvpetclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.diligentgroup.sfgthvpetclinic.model.Owner;
import com.diligentgroup.sfgthvpetclinic.model.Pet;
import com.diligentgroup.sfgthvpetclinic.model.PetType;
import com.diligentgroup.sfgthvpetclinic.model.Specialty;
import com.diligentgroup.sfgthvpetclinic.model.Vet;
import com.diligentgroup.sfgthvpetclinic.model.Visit;
import com.diligentgroup.sfgthvpetclinic.services.OwnerService;
import com.diligentgroup.sfgthvpetclinic.services.PetTypeService;
import com.diligentgroup.sfgthvpetclinic.services.SpecialtyService;
import com.diligentgroup.sfgthvpetclinic.services.VetService;
import com.diligentgroup.sfgthvpetclinic.services.VisitService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialtyService specialtyService;
	private final VisitService visitService;

	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
			SpecialtyService specialtyService, VisitService visitService) {
		super();
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialtyService = specialtyService;
		this.visitService = visitService;
	}

	@Override
	public void run(String... args) throws Exception {
		int count = petTypeService.findAll().size();
		if (count == 0) {
			loadData();
		}

	}

	private void loadData() {
		
		PetType dog = petTypeService.save(PetType.builder().name("Dog").build());
		PetType cat = petTypeService.save(PetType.builder().name("Cat").build());

		System.out.println("PetTypes loaded!");

		Specialty radiology = specialtyService.save(Specialty.builder().description("Radiology").build());
		specialtyService.save(Specialty.builder().description("Dentistry").build());
		Specialty surgery = specialtyService.save(Specialty.builder().description("Surgery").build());

		System.out.println("Specialties loaded!");

		Owner owner = Owner.builder().address("123 Main St").city("Roswell")
				.telephone("770-591-4515").firstName("Michael").lastName("Weston").build();
		Pet michaelsPet = Pet.builder().birthDate(LocalDate.now()).name("Fido").petType(dog).owner(owner).build();
		owner.addPet(michaelsPet);
		ownerService.save(owner);

		owner = Owner.builder().address("456 First St").city("Griffin")
				.telephone("770-555-1212").firstName("Fiona").lastName("Glenanne").build();
		Pet fionasPet = Pet.builder().birthDate(LocalDate.now()).name("Felix").petType(cat).owner(owner).build();
		owner.addPet(fionasPet);
		ownerService.save(owner);

		System.out.println("Owners loaded!");

		Vet vet = Vet.builder().firstName("Sam").lastName("Axe").build();
		vet.addSpecialty(surgery);
		vetService.save(vet);

		vet = Vet.builder().firstName("Tom").lastName("Lemay").build();
		vet.addSpecialty(radiology);
		vetService.save(vet);

		System.out.println("Vets loaded!");
		
		Visit catVisit = Visit.builder().date(LocalDate.now()).description("Sneezy Kitty").pet(fionasPet).build();
        visitService.save(catVisit);

		catVisit = Visit.builder().date(LocalDate.now()).description("Soft Kitty").pet(fionasPet).build();
        visitService.save(catVisit);

        System.out.println("Loaded Visits....");

	}

}
