package com.diligentgroup.sfgthvpetclinic.controllers;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.diligentgroup.sfgthvpetclinic.model.Owner;
import com.diligentgroup.sfgthvpetclinic.model.Pet;
import com.diligentgroup.sfgthvpetclinic.model.PetType;
import com.diligentgroup.sfgthvpetclinic.services.OwnerService;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {
	
	private String[] lastNames = { "Smith", "Jones", "Doe" };
	private String[] petNames = { "Billy", "Porky" };
	private String[] petTypeNames = { "Goat", "Pig" };
	private Long[] ids = { 1L, 2L, 3L };

	@Mock
	private OwnerService ownerService;
	
	@InjectMocks
	OwnerController controller;
	
	private Set<Owner> owners;
	
	MockMvc mockMvc;

	@BeforeEach
	void setUp() throws Exception {
		
		owners = new HashSet<>();
		Owner owner = Owner.builder().id(ids[0]).lastName(lastNames[0]).build();
		owner.addPet(Pet.builder().birthDate(LocalDate.now()).name(petNames[0]).owner(owner)
				.petType(PetType.builder().name(petTypeNames[0]).build()).build());
		owners.add(owner);
		owner = Owner.builder().id(ids[1]).lastName(lastNames[1]).build();
		owner.addPet(Pet.builder().birthDate(LocalDate.now()).name(petNames[1]).owner(owner)
				.petType(PetType.builder().name(petTypeNames[1]).build()).build());
		owners.add(owner);
		
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	void testOwnersList() throws Exception {
		when(ownerService.findAll()).thenReturn(owners);
		mockMvc.perform(get("/owners"))
			.andExpect(status().is(200))
			.andExpect(view().name("owners/index"))
			.andExpect(model().attribute("owners", hasSize(2)));
		
		mockMvc.perform(get("/owners/index")).andExpect(status().isOk());
		mockMvc.perform(get("/owners/index.html")).andExpect(status().is(200));
		mockMvc.perform(get("/owner")).andExpect(status().isNotFound());
	}

	@Test
	void testOwnersFind() throws Exception {
		mockMvc.perform(get("/owners/find"))
			.andExpect(status().isOk())
			.andExpect(view().name("underConstruction"));
		verifyZeroInteractions(ownerService);
	}

}
