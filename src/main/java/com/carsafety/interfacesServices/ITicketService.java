package com.carsafety.interfacesServices;

import java.util.List;
import java.util.Optional;

import com.carsafety.model.Ticket;

public interface ITicketService {
	
	public int guardar(Ticket tic);
	public int editar(Ticket tic);
	public Optional<Ticket> listarId(Long id);
	public int guardarGenerarOrdenPago(Ticket tic);
	
	public Ticket registrarTicket(Ticket tic);
	public Ticket ticketId(Long id);
	public List<Ticket> listarTickets();
	public List<Ticket> listarTicketsPorEstado(String estado);
	public void eliminar(Long id);

}
