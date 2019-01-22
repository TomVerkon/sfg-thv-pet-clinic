package com.diligentgroup.sfgthvpetclinic.services.springdatajpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.diligentgroup.sfgthvpetclinic.model.Owner;
import com.diligentgroup.sfgthvpetclinic.model.Pet;
import com.diligentgroup.sfgthvpetclinic.model.PetType;
import com.diligentgroup.sfgthvpetclinic.repositories.OwnerRepository;

@ExtendWith(MockitoExtension.class)
class OwnerServiceJpaTest {

	private String[] lastNames = { "Smith", "Jones", "Doe" };
	private String[] petNames = { "Billy", "Porky" };
	private String[] petTypeNames = { "Goat", "Pig" };
	private Long[] ids = { 1L, 2L, 3L };

	@Mock
	private OwnerRepository ownerRepository;

	@InjectMocks
	private OwnerServiceJpa service;

	private Owner returnOwner;

	@BeforeEach
	void setUp() throws Exception {
		returnOwner = Owner.builder().id(ids[0]).lastName(lastNames[0]).build();
		returnOwner.addPet(Pet.builder().birthDate(LocalDate.now()).name(petNames[0]).owner(returnOwner)
				.petType(PetType.builder().name(petTypeNames[0]).build()).build());
	}

	@Test
	void testFindAll() {
		Set<Owner> returnOwnersSet = new HashSet<>();
		returnOwnersSet.add(Owner.builder().id(ids[0]).lastName(lastNames[0]).build());
		returnOwnersSet.add(Owner.builder().id(ids[1]).lastName(lastNames[1]).build());

		when(ownerRepository.findAll()).thenReturn(returnOwnersSet);

		Set<Owner> owners = service.findAll();

		assertTrue(!owners.isEmpty());
		assertEquals(2, owners.size());
	}

	@Test
	void testFindById() {
		when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));

		Owner owner = service.findById(ids[0]);

		assertNotNull(owner);
	}

	@Test
	void testSave() {
		Owner ownerToSave = Owner.builder().id(1L).build();

		when(ownerRepository.save(any())).thenReturn(returnOwner);

		Owner savedOwner = service.save(ownerToSave);

		assertNotNull(savedOwner);

		verify(ownerRepository).save(any());
	}

	@Test
	void testDelete() {
		service.delete(returnOwner);

		// default is 1 times
		verify(ownerRepository, times(1)).delete(any());
	}

	@Test
	void testDeleteById() {
		service.deleteById(1L);

		verify(ownerRepository).deleteById(anyLong());
	}

	@Test
	void testFindByLastName() {
		when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);

		Owner owner = service.findByLastName(lastNames[0]);

		assertEquals(lastNames[0], owner.getLastName());

		verify(ownerRepository).findByLastName(any());
	}

}
