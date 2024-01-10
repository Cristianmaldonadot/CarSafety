package com.carsafety.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.carsafety.model.Contrato;

@Repository
public interface IContrato extends CrudRepository<Contrato, Long> {

}
