package com.ofsystem.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table (name = "usuario")
@Data
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int idUser;
	@Column(name = "username", nullable = false, length = 150)
	public String username;
	@Column(name = "password", nullable = false, length = 500)
	public String password;
	@Column(name = "estadoUser", nullable = false)
	public boolean estadoUser;

	@ManyToOne
    @JoinColumn(name="idRol", referencedColumnName = "idRol")
	public Rol iRol;



	
}
