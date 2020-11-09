package com.example.securityApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.securityApp.dao.UserRepository;
import com.example.securityApp.dao.VillageRepository;

@Controller
public class ViewController {
	
	private ModelAndView mdv;
	@Autowired
	private VillageRepository iVillage;
	
	public ViewController() {
		mdv = new ModelAndView();
	}
	
	//@GetMapping(value= {"/"})
	public ModelAndView getHomePage(){
		this.mdv.addObject("nom", "SECK NGOR");
		this.mdv.setViewName("/home/Home");
		return this.mdv;
	}
	
	@GetMapping(value= {"/"})
	public ModelAndView getClientPage() {
		this.mdv.addObject("villages", iVillage.findAll());
		mdv.setViewName("/home/client");
		return this.mdv;
	}
	
	@GetMapping(value= {"/village"})
	public ModelAndView getVillagePage() {
		mdv.setViewName("/home/village");
		return this.mdv;
	}
	
	

	
	
	
	
	
}
