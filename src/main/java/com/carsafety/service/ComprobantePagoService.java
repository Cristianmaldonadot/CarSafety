package com.carsafety.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carsafety.interfaces.IComprobantePago;
import com.carsafety.interfacesServices.IComprobantePagoService;
import com.carsafety.interfacesServices.IOrdenPagoService;
import com.carsafety.model.ComprobantePago;
import com.carsafety.model.OrdenPago;

@Service
public class ComprobantePagoService implements IComprobantePagoService {

	@Autowired
	private IComprobantePago data;
	
	@Autowired
	private IOrdenPagoService dataOrdenPago;
	
	@Override
	public int guardar(ComprobantePago conp) {
		int res=0;
		ComprobantePago comprobantepago = data.save(conp);
		
		OrdenPago ordenPago = dataOrdenPago.buscarId(conp.getOrdenPago().getIdordenpago());
		ordenPago.setEstado("Pagado");
		dataOrdenPago.guardar(ordenPago);
		
		if(comprobantepago.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public List<ComprobantePago> listarComprobantes() {
		return (List<ComprobantePago>) data.findAll();
	}

}
