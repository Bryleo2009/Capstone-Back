package com.ofsystem.Capstone.Model.Enums;


import com.ofsystem.Capstone.Model.Enums.Name.RolName;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;


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
