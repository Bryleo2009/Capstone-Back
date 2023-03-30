package com.ofsystem.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table (name = "usuario")
@Data
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int idUser;
	@Column(name = "username", nullable = false, length = 150)
    @Size(min = 3, message = "Minimo 3 caracteres")
	public String username;
	@Column(name = "password", nullable = false, length = 500)
    @Size(min = 5, message = "Minimo 5 caracteres")
	public String password;
	@Column(name = "estadoUser", nullable = false)
	public boolean estadoUser;

	@ManyToOne
    @JoinColumn(name="idRol", referencedColumnName = "idRol")
	public Rol iRol;

	@OneToOne
    @JoinColumn(name="dniTraba", referencedColumnName = "dniTraba")
	public Trabajador dniTraba;

	
}
