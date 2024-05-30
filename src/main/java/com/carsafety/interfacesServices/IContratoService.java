package com.carsafety.interfacesServices;

import java.util.List;
import java.util.Optional;

import com.carsafety.model.Contrato;

public interface IContratoService {
	
	public Optional<Contrato> listarId(Long id);
	public int guardarGenerarOrdenPago(Contrato con);
	public List<Contrato> listarContratos();
	public Contrato contratoId(Long id);

}
