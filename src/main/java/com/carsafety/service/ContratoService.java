package com.carsafety.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carsafety.interfaces.IContrato;
import com.carsafety.interfaces.IOrdenPago;
import com.carsafety.interfacesServices.IContratoService;
import com.carsafety.model.Contrato;
import com.carsafety.model.OrdenPago;

@Service
public class ContratoService implements IContratoService {
	
	@Autowired
	private IContrato data;
	
	@Autowired
	private IOrdenPago dataorden;

	
	@Override
	public int guardarGenerarOrdenPago(Contrato con) {
		int res=0;
		Contrato contrato = data.save(con);
		
		OrdenPago ordenpago = new OrdenPago();
		ordenpago.setContrato(contrato);
		ordenpago.setMonto(contrato.getMonto());
		LocalDate fechaActual = LocalDate.now();
		Date dateFechaActual = java.sql.Date.valueOf(fechaActual);
		ordenpago.setFecha(dateFechaActual);
		ordenpago.setDetalle("Pago Abonado");
		
		dataorden.save(ordenpago);
		
		//ticket.setOrdenDePago(ordenpago);
		data.save(contrato);
		
		if(contrato.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public Optional<Contrato> listarId(Long id) {
		return data.findById(id);
	}

	@Override
	public List<Contrato> listarContratos() {
		return (List<Contrato>) data.findAll();
	}

	@Override
	public Contrato contratoId(Long id) {
		Optional<Contrato> optionalCliente = data.findById(id);
		return optionalCliente.orElse(null);
	}

}
