package com.ofsystem.Model;



import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table (name = "trabajador")
@Data
public class Trabajador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int idtraba;
	@Size(min = 8, message = "Minimo 8 caracteres")
	public String dniTraba;
	@Column(name = "nombreTraba", nullable = false, length = 300)
    @Size(min = 3, message = "Minimo 3 caracteres")
	public String nombreTraba;
	@Column(name = "apellidoTraba", nullable = false, length = 300)
    @Size(min = 3, message = "Minimo 3 caracteres")
	public String apellidoTraba;
	@Column(name = "fechaNacTraba")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@JsonFormat(pattern = "dd/MM/yyyy", timezone = "GMT-5")
	public java.sql.Date fechaNacTraba;
	@Column(name = "telefonoTraba",  length = 9)
	public String telefonoTraba;
	@Column(name = "direccionTraba", length = 45)
	public String direccionTraba;
	public String imagen;
	@OneToOne
	@JoinColumn(name="idUser", referencedColumnName = "idUser")
	public Usuario idUser;
	public Integer getIdTp() {
		// TODO Auto-generated method stub
		return null;
	}

	



	
}
