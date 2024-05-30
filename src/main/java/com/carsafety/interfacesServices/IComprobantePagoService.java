package com.carsafety.interfacesServices;

import java.util.List;

import com.carsafety.model.ComprobantePago;

public interface IComprobantePagoService {
	
	public int guardar(ComprobantePago cli);
	public List<ComprobantePago> listarComprobantes();
	
}
