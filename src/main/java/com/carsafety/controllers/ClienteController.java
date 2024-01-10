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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.carsafety.model.Cliente;
import com.carsafety.model.ComprobantePago;
import com.carsafety.model.Contrato;
import com.carsafety.model.OrdenPago;
import com.carsafety.service.ClienteService;
import com.carsafety.service.OrdenPagoService;

@RestController
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@Autowired
	private OrdenPagoService serviceOrden;
	
	@PostMapping("/registrarcliente")
	public Cliente agregar(@RequestParam Long id, @RequestParam String nombre,@RequestParam String telefono, 
			@RequestParam String email, @RequestParam String direccion ) {
		
		Cliente cliente = new Cliente(id, nombre, telefono, email, direccion, null);
		
		return service.registrarCliente(cliente);
	}
	
	@PostMapping("/savecliente")
	public String guardar(@Validated Cliente t, Model model) {
		
		service.guardar(t);
		return "redirect:/registrarcliente";
	}
	
	@GetMapping("/buscarcliente/{id}")
	public Cliente buscarCliente(@PathVariable Long id) {
		Cliente cliente = service.clienteId(id);
		return cliente;
	}
	
	@GetMapping("/listarclientes")
	public List<Cliente> listarTodos() {
		return service.listar();
	}
	
	@GetMapping("/eliminarcliente/{id}")
	public String eliminar(@PathVariable Long id, Model model) {
		service.eliminar(id);
		return "Cliente Eliminado";
	}
	
	@GetMapping("/buscarorden/{id}")
	public OrdenPago buscarOrden(@PathVariable Long id) {
		OrdenPago ordenPago = serviceOrden.buscarId(id);
		return ordenPago;
	}

}
