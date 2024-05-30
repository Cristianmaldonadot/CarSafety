package com.carsafety.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carsafety.model.Cliente;
import com.carsafety.model.Contrato;
import com.carsafety.model.Ticket;
import com.carsafety.service.ContratoService;

@RestController
public class ContratoContoller {
	
	@Autowired
	private ContratoService service;
	
	
	@PostMapping("/guardarcontrato")
	public String guardarsalida(@Validated @RequestBody Contrato c) {
		
		service.guardarGenerarOrdenPago(c);
		return "redirect:/gestionarticket";
	}
	
	@GetMapping("/listarcontratos")
	public List<Contrato> listarContratos(){
		return service.listarContratos();
	}
	
	@GetMapping("/buscarcontrato/{id}")
	public Contrato buscarContrato(@PathVariable Long id) {
		Contrato contrato = service.contratoId(id);
		return contrato;
	}

}
