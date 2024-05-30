package com.carsafety.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carsafety.interfaces.IOrdenPago;
import com.carsafety.interfaces.ITicket;
import com.carsafety.interfacesServices.ITicketService;
import com.carsafety.model.OrdenPago;
import com.carsafety.model.Ticket;

@Service
public class TicketService implements ITicketService {
	
	@Autowired
	private ITicket data;
	
	@Autowired
	private IOrdenPago ordenPagoService;

	@Override
	public int guardar(Ticket tic) {
		int res=0;
		Ticket ticket = data.save(tic);
		if(ticket.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public int editar(Ticket tic) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Optional<Ticket> listarId(Long id) {
		return data.findById(id);
	}

	@Override
	public int guardarGenerarOrdenPago(Ticket tic) {
		int res=0;
		Ticket ticket = data.save(tic);
		
		OrdenPago ordenpago = new OrdenPago();
		ordenpago.setTicket(ticket);
		ordenpago.setMonto(ticket.getPreciototal());
		LocalDate fechaActual = LocalDate.now();
		Date dateFechaActual = java.sql.Date.valueOf(fechaActual);
		ordenpago.setFecha(dateFechaActual);
		ordenpago.setDetalle("Pago Ticket");
		
		ordenPagoService.save(ordenpago);
		
		//ticket.setOrdenDePago(ordenpago);
		data.save(ticket);
		
		if(ticket.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public Ticket registrarTicket(Ticket tic) {
		return data.save(tic);
	}

	@Override
	public Ticket ticketId(Long id) {
		Optional<Ticket> optionalTicket = data.findById(id);
		return optionalTicket.orElse(null);
	}

	@Override
	public List<Ticket> listarTickets() {
		return (List<Ticket>) data.findAll();
	}

	@Override
	public List<Ticket> listarTicketsPorEstado(String estado) {
		return data.findByEstado(estado);
	}

	@Override
	public void eliminar(Long id) {
		data.deleteById(id);
	}

}
