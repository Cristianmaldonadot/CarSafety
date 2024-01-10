package com.carsafety.interfaces;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.carsafety.model.Usuario;

@Repository
public interface IUsuario extends CrudRepository<Usuario, Long> {
	
	Optional<Usuario> findByUsername(String username);

}
