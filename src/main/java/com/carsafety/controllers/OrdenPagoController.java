package com.carsafety.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carsafety.model.OrdenPago;
import com.carsafety.service.OrdenPagoService;

@RestController
public class OrdenPagoController {
	
	@Autowired
	private OrdenPagoService service;
	
	@GetMapping("/listarorden")
	public List<OrdenPago> listarOrden(){
		return service.listar();
	}

}
