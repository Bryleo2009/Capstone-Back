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
	@Column(name = "nomCliente", nullable = false, length = 45)
    @Size(min = 3, message = "Minimo 3 caracteres")
	public String nomCliente; //Juan Alkexander
	@Column(name = "apeCliente", nullable = false, length = 45)
    @Size(min = 3, message = "Minimo 3 caracteres")
	public String apeCliente; // Velazquez Soria
	
	
	
	

}
