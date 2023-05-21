package com.ofsystem.Model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table (name = "usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
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
	public Rol idRol;

	public Usuario(String username, String password, boolean estadoUser, Rol idRol) {
		this.username = username;
		this.password = password;
		this.estadoUser = estadoUser;
		this.idRol = idRol;
	}
}
