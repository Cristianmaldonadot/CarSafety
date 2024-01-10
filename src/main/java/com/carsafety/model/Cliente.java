package com.carsafety.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name= "cliente")
public class Cliente {
	
	@Id
	private Long idcliente;
	private String nombre;
	private String telefono;
	private String email;
	private String direccion;
	private String tipocliente;
	
	public Cliente() {
	}
	
	@PrePersist
	public void prePersist() {
        if (tipocliente == null) {
        	tipocliente = "Comun";
        }
    }
	

}
