package com.carsafety.controllers;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.carsafety.model.Ticket;
import com.carsafety.service.TicketService;

@RestController
public class TicketController {
	
	@Autowired
	private TicketService service;
	
	@PostMapping("/registrarticket")
	public Ticket agregar(@RequestParam double tipovehiculo,@RequestParam String placa, 
			@RequestParam Time horaingreso, @RequestParam Date fechaentrada) {
		
		Ticket ticket = new Ticket(tipovehiculo, placa, horaingreso, fechaentrada, null );
		
		return service.registrarTicket(ticket);
	}
	
	@GetMapping("/editarticket/{id}")
	public Ticket editarticket(@PathVariable Long id) {
		Ticket ticket = service.ticketId(id);
		return ticket;
	}
	
	@GetMapping("/listartickets")
	public List<Ticket> listarTodos() {
		return service.listarTickets();
	}
	
	
	@PostMapping("/savesalida")
	public String guardarsalida(@Validated @RequestBody Ticket t) {
		
		service.guardarGenerarOrdenPago(t);
		return "redirect:/gestionarticket";
	}
	
	@GetMapping("/listarticketsporestado")
    public List<Ticket> listarPorEstado(@RequestParam("estado") String estado) {
        return service.listarTicketsPorEstado(estado);
    }
	@PostMapping("/eliminarticket/{id}")
    public void eliminarticket(@PathVariable Long id) {
        service.eliminar(id);
    }

}
