package com.carsafety.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.carsafety.model.RolEntity;

@Repository
public interface IRolEntity extends CrudRepository<RolEntity, Long> {

}
