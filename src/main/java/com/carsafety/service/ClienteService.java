package com.carsafety.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carsafety.interfaces.ICliente;
import com.carsafety.interfacesServices.IClienteService;
import com.carsafety.model.Cliente;

@Service
public class ClienteService implements IClienteService {

	@Autowired
	private ICliente data;
	
	@Override
	public int guardar(Cliente cli) {
		int res=0;
		Cliente cliente = data.save(cli);
		if(cliente.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public Optional<Cliente> listarId(Long id) {
		return data.findById(id);
	}

	@Override
	public List<Cliente> listar() {
		return (List<Cliente>) data.findAll();
	}

	@Override
	public void eliminar(Long id) {
		data.deleteById(id);
	}

	@Override
	public Cliente registrarCliente(Cliente cli) {
		return data.save(cli);
	}

	@Override
	public Cliente clienteId(Long id) {
		Optional<Cliente> optionalCliente = data.findById(id);
		return optionalCliente.orElse(null);
	}

}
