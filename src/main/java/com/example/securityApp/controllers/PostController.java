package com.example.securityApp.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.securityApp.dao.ClientRepository;
import com.example.securityApp.dao.VillageRepository;
import com.example.securityApp.entities.Client;
import com.example.securityApp.entities.Village;

@Controller
public class PostController {
	@Autowired
	private VillageRepository villagerepo;
	
	@Autowired
	private ClientRepository clientrepo;
	
	@PostMapping(value= {"/addVillage"})
	public String insertVillage(@Validated Village village) {
		//save the village 
		villagerepo.save(village);
		return "redirect:/message.insertion village reussi";
	}
	
	@PostMapping(value= {"/addClient"})
	public String insertClient(@Validated Client client,HttpServletRequest req) {
		//fetch the village for the user
		client.setVillage(villagerepo.findById(Integer.parseInt(req.getParameter("id_village"))).orElse(null));
		
		//insert the client
		clientrepo.save(client);
		return "redirect:/message.INSERTION CLIENT REUSSIE";
	}
	
	
	
	
}
