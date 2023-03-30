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
@Table(name = "rol")
@Data
public class Rol {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int idRol;
	@Column(name = "nombreTp", nullable = false, length = 20)
    @Size(min = 3, message = "Minimo 3 caracteres")
	public String nombreRol;
	
	
}
