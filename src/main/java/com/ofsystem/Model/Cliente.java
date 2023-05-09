package com.ofsystem.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "cliente")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int idCliente;
	@Column(name = "nombreCliente", nullable = false, length = 45)
	public String nombreCliente; //Juan Alkexander
	@Column(name = "apellidoCliente", nullable = false, length = 70)
	public String apellidoCliente; // Velazquez Soria
	@Column(name = "direccionCliente", nullable = false, length = 95)
	public String direccionCliente; //Av.alarcon cercado de lima 45567
	@Column(name = "telefonoCliente", nullable = false, length = 45)
	public String telefonoCliente; //987474234
	@Column(name = "ubigueoCliente", nullable = false, length = 45)
	public int ubigueoCliente;
	@Column(name = "username", nullable = false, length = 150)
	public String username;
	
	
	
	

}
