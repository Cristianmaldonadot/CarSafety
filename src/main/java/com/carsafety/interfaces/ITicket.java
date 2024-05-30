package com.carsafety.interfaces;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.carsafety.model.Ticket;

@Repository
public interface ITicket extends CrudRepository<Ticket, Long> {
	
	List<Ticket> findByEstado(String estado);
}
