package com.ofsystem.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table (name = "cliente")
@Data

public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int idCliente;
	@Column(name = "nombreCliente", nullable = false, length = 45)
    @Size(min = 6, message = "Minimo 3 caracteres")
	public String nombreCliente; //Juan Alkexander
	@Column(name = "apellidoCliente", nullable = false, length = 70)
    @Size(min = 8, message = "Minimo 3 caracteres")
	public String apellidoCliente; // Velazquez Soria
	@Column(name = "direccionCliente", nullable = false, length = 95)
    @Size(min = 10, message = "Minimo 10 caracteres")
	public String direccionCliente; //Av.alarcon cercado de lima 45567
	@Column(name = "telefonoCliente", nullable = false, length = 45)
    @Size(min = 9, message = "Minimo 9 caracteres")
	public String telefonoCliente; //987474234
	@Column(name = "ubigueoCliente", nullable = false, length = 45)
    @Size(min = 5, message = "Minimo 5 caracteres")
	public int ubigueoCliente;
	@Column(name = "username", nullable = false, length = 150)
    @Size(min = 3, message = "Minimo 3 caracteres")
	public String username;
	
	
	
	

}
