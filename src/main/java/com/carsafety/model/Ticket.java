package com.carsafety.model;

import java.sql.Date;
import java.sql.Time;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name= "ticket")
public class Ticket {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "random-id")
    @GenericGenerator(name = "random-id", strategy = "com.carsafety.RandomIdGenerator")
	private Long idticket;
	private double tipovehiculo;
	private String placa;
	private Time horaingreso;
	private Time horasalida;
	private Date fechaentrada;
	private String tiempotranscurrido;
	private double preciototal;
	private String estado;
	
	
	public Ticket() {
	}
	
	
	
	@PrePersist
    public void prePersist() {
        if (estado == null) {
            // Si el atributo es null, asignar un valor predeterminado antes de guardar en la base de datos
        	estado = "Valido";
        }
    }



	public Ticket(double tipovehiculo, String placa, Time horaingreso, Date fechaentrada, String estado) {
		super();
		this.tipovehiculo = tipovehiculo;
		this.placa = placa;
		this.horaingreso = horaingreso;
		this.fechaentrada = fechaentrada;
		this.estado = estado;
	}

	
	
	
}
