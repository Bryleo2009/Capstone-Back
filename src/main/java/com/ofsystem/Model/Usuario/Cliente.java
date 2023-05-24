package com.ofsystem.Model.Usuario;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Entity
@Table (name = "cliente")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	@Column(name = "nombre", nullable = false, length = 1000)
	public String nombre; //Juan Alkexander
	@Column(name = "apellido", nullable = false, length = 1000)
	public String apellido; // Velazquez Soria
	@Column(name = "fechaNac")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@JsonFormat(pattern = "dd/MM/yyyy", timezone = "GMT-5")
	public Date fechaNac;
	@Column(name = "telefono", nullable = false, length = 45)
	public String telefono; //987474234
	@Column(name = "direccionCliente", nullable = false, length = 1000)
	public String direccion; //Av.alarcon cercado de lima 45567
	@Column(name = "ubigueoCliente", nullable = false, length = 45)
	public String ubigueo;
	@Column(name = "numDocumento", nullable = false, length = 1000)
	public String numDocumento;
	@OneToOne
	@JoinColumn(name="idUserCliente", referencedColumnName = "idUser")
	public Usuario idUserCliente;

	public Cliente(String nombre, String apellido, Date fechaNac, String telefono, String direccion, String ubigueo, String numDocumento, Usuario idUserCliente) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNac = fechaNac;
		this.telefono = telefono;
		this.direccion = direccion;
		this.ubigueo = ubigueo;
		this.numDocumento = numDocumento;
		this.idUserCliente = idUserCliente;
	}
}
