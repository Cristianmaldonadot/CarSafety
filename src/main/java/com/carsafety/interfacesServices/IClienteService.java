package com.carsafety.interfacesServices;

import java.util.List;
import java.util.Optional;

import com.carsafety.model.Cliente;

public interface IClienteService {
	
	public int guardar(Cliente cli);
	public Optional<Cliente> listarId(Long id);
	public List<Cliente> listar();
	public void eliminar(Long id);
	
	public Cliente registrarCliente(Cliente cli);
	public Cliente clienteId(Long id);

}
