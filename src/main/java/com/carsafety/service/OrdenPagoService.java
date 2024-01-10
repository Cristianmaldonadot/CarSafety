package com.carsafety.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carsafety.interfaces.IOrdenPago;
import com.carsafety.interfacesServices.IOrdenPagoService;
import com.carsafety.model.OrdenPago;

@Service
public class OrdenPagoService implements IOrdenPagoService {
	
	@Autowired
	private IOrdenPago data;

	@Override
	public int guardar(OrdenPago op) {
		int res=0;
		OrdenPago ordenpago = data.save(op);
		if(ordenpago.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public OrdenPago buscarId(Long id) {
		Optional<OrdenPago> ordenPago = data.findById(id);
		return ordenPago.orElse(null);
	}

	@Override
	public List<OrdenPago> listar() {
		return (List<OrdenPago>) data.findAll();
	}

	
}
