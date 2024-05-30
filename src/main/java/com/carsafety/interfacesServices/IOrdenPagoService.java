package com.carsafety.interfacesServices;

import java.util.List;
import java.util.Optional;

import com.carsafety.model.OrdenPago;

public interface IOrdenPagoService {
	
	public int guardar(OrdenPago con);
	public OrdenPago buscarId(Long id);
	public List<OrdenPago> listar();

}
