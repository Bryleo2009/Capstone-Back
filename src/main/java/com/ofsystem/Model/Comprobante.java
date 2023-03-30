package com.ofsystem.Model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table (name = "comprobante")
@Data
public class Comprobante {
	@Id
        @Column(length = 50)
	public String idComp;
	@Column(name = "nomClientComp", nullable = false, length = 45)
    @Size(min = 3, message = "Minimo 3 caracteres")
	public String nomClient_comp; //Juan Alkexander
	@Column(name = "identClientComp", nullable = false, length = 15)
    @Size(min = 8, message = "Minimo 8 caracteres")
	public String identClientComp; //ruc o dni
	@Column(name = "montoSubtotalComp", nullable = false)
	public double montoSubtotalComp; //suma de los totales de items sin igv
	@Column(name = "montoTotalComp", nullable = false)
	public double montoTotalComp; //incluido igv
	@Column(name = "fechaEmiComp", nullable = false)
	public java.sql.Date fechaEmiComp; //21/01/2021

	@ManyToOne
    @JoinColumn(name="idTp", referencedColumnName = "idTp")
	public TipoPago idTp;

	@ManyToOne
    @JoinColumn(name="idTc", referencedColumnName = "idTc")
	public TipoCompro idTc;

	@ManyToOne
    @JoinColumn(name="idUser", referencedColumnName = "idUser")
	public Usuario idUser;


	


	
	
}
