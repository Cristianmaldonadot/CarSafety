package com.carsafety.model;

import java.sql.Date;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name= "contrato")
public class Contrato {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "random-id")
    @GenericGenerator(name = "random-id", strategy = "com.carsafety.RandomIdGenerator")
	private Long idcontrato;
	@ManyToOne
	@JoinColumn(name = "idcliente")
    private Cliente cliente;
	private String marcavehiculo;
	private String placavehiculo;
	private String colorvehiculo;
	private String tipovehiculo;
	private String tiempocontrato;
	private Date fechainicio;
	private Date fechavencimiento;
	private double monto;
	private String estadocontrato;
	private Long refidcontrato;
	
	
	
	public Contrato() {
	}
	
	@PrePersist
	public void prePersist() {
        if (estadocontrato == null) {
        	estadocontrato = "Vigente";
        }
    }
	
	
	
}
