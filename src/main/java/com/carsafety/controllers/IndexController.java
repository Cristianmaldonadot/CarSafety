package com.carsafety.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@CrossOrigin
public class IndexController {
	
	
	@GetMapping(value = {"/menuprincipal"})
	public String menuprincipal() {
		return "menuprincipal";
	}
	@GetMapping(value = {"/registrarticket"})
	public String registrarticket() {
		return "registrarticket";
	}

	@CrossOrigin
	@GetMapping(value = {"/login"})
	public String loggin() {
		return "login";
	}
	
	/*
	 * @PostMapping(value = {"/logginprocess"}) public String
	 * logpinprocess(@RequestParam String username, @RequestParam String password,
	 * Model model) { return "redirect:/index"; }
	 */
	
	@GetMapping(value = {"/nombres"})
	public String nom() {
		return "nombres";
	}
	
	@GetMapping(value = {"/xxxx"})
	public String ticket() {
		return "xxxx";
	}
	
	@GetMapping(value = {"/yyyyy"})
	public String gesticket() {
		return "yyyyy";
	}
}
