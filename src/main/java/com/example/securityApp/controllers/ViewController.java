package com.example.securityApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {
	
	private ModelAndView mdv;
	
	public ViewController() {
		mdv = new ModelAndView();
	}
	
//	@GetMapping(value= {"/"})
//	public ModelAndView getHomePage() {
//		this.mdv.addObject("nom", "SECK NGOR");
//		this.mdv.setViewName("/home/Home");
//		return this.mdv;
//	}
	
//	@GetMapping(value= {"/"})
//	public ModelAndView getHomePage() {
//		mdv.addObject("view", "CLIENT | PAGE");
//		mdv.setViewName("/home/client");
//		return this.mdv;
//	}
	
	@GetMapping(value= {"/"})
	public ModelAndView getHomePage() {
		mdv.setViewName("/home/village");
		return this.mdv;
	}
	
	

	
	
	
	
	
}
