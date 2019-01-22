package com.diligentgroup.sfgthvpetclinic.services.map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.diligentgroup.sfgthvpetclinic.model.Owner;
import com.diligentgroup.sfgthvpetclinic.services.OwnerService;

class OwnerServiceMapTest {

	private OwnerService ownerService;
	private String[] lastNames = {"Smith","Jones", "Doe"};
	private Long[] ids = {1L, 2L, 3L};

	@BeforeEach
	void setUp() throws Exception {
		this.ownerService = new OwnerServiceMap(new PetServiceMap(), new PetTypeServiceMap());
		this.ownerService.save(Owner.builder().id(ids[0]).lastName(lastNames[0]).build());
		this.ownerService.save(Owner.builder().id(ids[1]).lastName(lastNames[1]).build());
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
		assertNotNull(this.ownerService.findById(ids[0]));
		assertEquals(ids[0], this.ownerService.findById(ids[0]).getId());
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
