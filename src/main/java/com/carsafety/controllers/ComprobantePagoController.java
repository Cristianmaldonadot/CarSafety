package com.carsafety.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carsafety.model.Cliente;
import com.carsafety.model.ComprobantePago;
import com.carsafety.model.Contrato;
import com.carsafety.model.OrdenPago;
import com.carsafety.service.ComprobantePagoService;

@RestController
public class ComprobantePagoController {
	
	@Autowired
	private ComprobantePagoService service;
	
	@PostMapping("/registrarcomprobante")
	public String guardar(@Validated @RequestBody ComprobantePago t) {
		
		service.guardar(t);
		return "redirect:/index";
	}
	
	@GetMapping("/listarcomprobantes")
	public List<ComprobantePago> listarComprobantes(){
		return service.listarComprobantes();
	}

}
