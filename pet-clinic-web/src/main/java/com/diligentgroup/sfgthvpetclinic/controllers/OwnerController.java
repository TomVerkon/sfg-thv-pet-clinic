package com.diligentgroup.sfgthvpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.diligentgroup.sfgthvpetclinic.services.OwnerService;

@RequestMapping("/owners")
@Controller
public class OwnerController {
	
	private OwnerService ownerService;
	
	public OwnerController(OwnerService ownerService) {
		this.ownerService = ownerService;
	}
	
	@RequestMapping({"", "index", "index.html"})
	public String ownersList(Model model) {
		model.addAttribute("owners", ownerService.findAll());
		return "owners/index";
	}
	
	@RequestMapping({"/find", "/find.html"})
	public String ownersFind(Model model) {
		return "underConstruction";
	}

}
