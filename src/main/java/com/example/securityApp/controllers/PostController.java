package com.example.securityApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.securityApp.dao.VillageRepository;
import com.example.securityApp.entities.Village;

@Controller
public class PostController {
	@Autowired
	private VillageRepository villagerepo;
	
	@PostMapping(value= {"/addVillage"})
	public String insertVillage(@Validated Village village) {
		//save the village 
		villagerepo.save(village);
		return "redirect:/message.insertion village reussi";
	}
	
	
	
	
}
