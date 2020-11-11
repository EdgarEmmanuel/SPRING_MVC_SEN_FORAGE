package com.example.securityApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.example.securityApp.dao.ClientRepository;
import com.example.securityApp.dao.VillageRepository;
import com.example.securityApp.entities.Client;
import com.example.securityApp.entities.Village;

@Controller
public class ViewController {
	
	private ModelAndView mdv;
	@Autowired
	private VillageRepository iVillage;
	
	@Autowired
	private ClientRepository clientrepo;
	
	public ViewController() {
		mdv = new ModelAndView();
	}
	
	@GetMapping(value= {"/"})
	public ModelAndView getLoginPage(Authentication authenticatePerson) {
		this.mdv.addObject("nom", authenticatePerson.getName());
		this.mdv.setViewName("/home/Home");
		return this.mdv;
	}
	
	@GetMapping(value= {"/listClient"})
	public ModelAndView getHomePage(){
		this.mdv.addObject("clients", clientrepo.findAll());
		this.mdv.setViewName("/home/list_client");
		return this.mdv;
	}
	
	@GetMapping(value= {"/listVillage"})
	public ModelAndView getListVillagePage(){
		this.mdv.addObject("villages", iVillage.findAll());
		this.mdv.setViewName("/home/list_village");
		return this.mdv;
	}
	
		@GetMapping(value= {"/message.{message}"})
		public ModelAndView getMessagePage(@PathVariable("message") String message){
			this.mdv.addObject("message", message);
			this.mdv.setViewName("home/message");
			return this.mdv;
		}
	
	@GetMapping(value= {"/addclient"})
	public ModelAndView getClientPage(Model model) {
		model.addAttribute("client", new Client());
		this.mdv.addObject("villages", iVillage.findAll());
		mdv.setViewName("/home/client");
		return this.mdv;
	}
	
	@GetMapping(value= {"/addvillage"})
	public ModelAndView getVillagePage(Model model) {
		model.addAttribute("village", new Village());
		mdv.setViewName("/home/village");
		return this.mdv;
	}
	
//	request for the security configuration
	@GetMapping(value= {"/login"})
	public ModelAndView getPageLOgin() {
		this.mdv.setViewName("home/login");
		return this.mdv;
	}
	
	@GetMapping(value= {"/logout-success"})
	public ModelAndView getLogout() {
		this.mdv.setViewName("home/login");
		return this.mdv;
	}
	
	

	
	
	
	
	
}
