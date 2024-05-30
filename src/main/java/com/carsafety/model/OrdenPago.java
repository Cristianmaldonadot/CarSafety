package com.carsafety.model;

import java.sql.Date;

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
@Table(name= "ordenpago")
public class OrdenPago {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idordenpago;
	
	@ManyToOne
    @JoinColumn(name = "idcontrato", nullable = true)
	private Contrato contrato;
	
	@ManyToOne
    @JoinColumn(name = "idticket", nullable = true)
	private Ticket ticket;
	
	private String detalle;
	private double monto;
	private Date fecha;
	private String estado;
	
	public OrdenPago() {
		
	}
	
	@PrePersist
    public void prePersist() {
        if (estado == null) {
            // Si el atributo es null, asignar un valor predeterminado antes de guardar en la base de datos
        	estado = "Pendiente";
        }
    }
	
	

}
