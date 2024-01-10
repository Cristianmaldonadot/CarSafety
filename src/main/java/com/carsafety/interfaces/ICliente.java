package com.carsafety.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.carsafety.model.Cliente;

@Repository
public interface ICliente extends CrudRepository<Cliente, Long> {

}
