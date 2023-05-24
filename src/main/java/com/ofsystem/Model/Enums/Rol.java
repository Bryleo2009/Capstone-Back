package com.ofsystem.Model;


import com.ofsystem.Enums.EtiquetaName;
import com.ofsystem.Enums.RolName;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "rol")
@Data
@AllArgsConstructor
public class Rol {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int idRol;
	@Enumerated(EnumType.STRING)
	@Column(name = "identItem", nullable = false)
	private RolName identItem;
	@Column(name = "nombreItem", nullable = true)
	private  String nombreItem;

	@Column(name = "abreviItem", nullable = false)
	private  String abreviItem;

	@Column(name = "vistaItem", nullable = true)
	private  String vistaItem;

	public Rol() {
	}

	public Rol(RolName ident) {
		this.identItem = ident;
		this.abreviItem = ident.getAbreviatura();
		this.nombreItem = ident.getValue();
		this.vistaItem = ident.getVista();
	}

	
	
}
