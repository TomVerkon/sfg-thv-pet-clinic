package com.diligentgroup.sfgthvpetclinic.services.map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.diligentgroup.sfgthvpetclinic.model.Owner;
import com.diligentgroup.sfgthvpetclinic.model.Pet;
import com.diligentgroup.sfgthvpetclinic.model.PetType;
import com.diligentgroup.sfgthvpetclinic.services.OwnerService;

class OwnerServiceMapTest {

	private OwnerService ownerService;
	private String[] lastNames = {"Smith","Jones", "Doe"};
	private String[] petNames = {"Billy","Porky"};
	private String[] petTypeNames = {"Goat","Pig"};
	private Long[] ids = {1L, 2L, 3L};

	@BeforeEach
	void setUp() throws Exception {
		this.ownerService = new OwnerServiceMap(new PetServiceMap(), new PetTypeServiceMap());
		Owner owner = Owner.builder().id(ids[0]).lastName(lastNames[0]).build();
		owner.addPet(Pet.builder()
				.birthDate(LocalDate.now())
				.name(petNames[0])
				.owner(owner)
				.petType(PetType.builder()
						.name(petTypeNames[0])
						.build())
				.build());
		this.ownerService.save(owner);
		owner = Owner.builder().id(ids[1]).lastName(lastNames[1]).build();
		owner.addPet(Pet.builder()
				.birthDate(LocalDate.now())
				.name(petNames[1])
				.owner(owner)
				.petType(PetType.builder()
						.name(petTypeNames[1])
						.build())
				.build());
		this.ownerService.save(owner);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testOwnerServiceMap() {
		assertNotNull(this.ownerService);
		
	}

	@Test
	void testFindByIdLong() {
		Owner owner = ownerService.findById(ids[0]);
		assertNotNull(owner);
		assertEquals(ids[0], owner.getId());
		assertEquals(1, owner.getPets().size());
		owner.getPets().forEach(pet -> {
			assertNotNull(pet.getPetType());
			assertEquals(pet.getPetType().getName(), petTypeNames[0]);
			assertEquals(owner.getId(), pet.getOwner().getId());
			assertEquals(pet.getName(), petNames[0]);
		});
	}

	@Test
	void testFindAll() {
		assertEquals(2, this.ownerService.findAll().size());
	}

	@Test
	void testSaveExistingOwner() {
		String newLastName = "Jagger";
		Owner owner = ownerService.findById(ids[1]);
		assertNotNull(owner);
		assertEquals(ids[1], owner.getId());
		owner.setLastName(newLastName);
		owner = ownerService.save(owner);
		assertNotNull(owner);
		assertEquals(ids[1], owner.getId());
		assertEquals(newLastName, owner.getLastName());
	}

	@Test
	void testSaveNewOwner() {
		Owner owner = ownerService.save(Owner.builder().lastName(lastNames[2]).build());
		assertNotNull(owner);
		assertNotNull(owner.getId());
		assertEquals(lastNames[2], owner.getLastName());
	}

	@Test
	void testDeleteByIdLong() {
		int beforeCount = ownerService.findAll().size();
		ownerService.deleteById(ids[0]);
		assertEquals(beforeCount, ownerService.findAll().size() + 1);
		assertNull(ownerService.findById(ids[0]));
	}

	@Test
	void testDeleteOwner() {
		Owner owner = ownerService.findById(ids[1]);
		assertNotNull(owner);
		ownerService.delete(owner);
		owner = ownerService.findById(ids[1]);
		assertNull(owner);
	}

	@Test
	void testFindByLastName() {
		Owner owner = ownerService.findByLastName(lastNames[1]);
		assertNotNull(owner);
		owner = ownerService.findByLastName("bagofdonuts");
		assertNull(owner);
	}

}
