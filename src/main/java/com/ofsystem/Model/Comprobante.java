package com.ofsystem.Model;

import java.util.Date;

import com.ofsystem.Enums.EstComproName;
import com.ofsystem.Enums.TipoComproName;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "comprobante")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comprobante {
	@Id
	@Column(length = 50)
	public String idComp;
	@Column(name = "nomClientComp", nullable = false, length = 45)
	public String nomClientComp; //Juan Alkexander
	@Column(name = "identClientComp", nullable = false, length = 15)
	public String identClientComp; //ruc o dni
	@Column(name = "montoSubtotalComp", nullable = false)
	public double montoSubtotalComp; //suma de los totales de items sin igv
	@Column(name = "montoTotalComp", nullable = false)
	public double montoTotalComp; //incluido igv
	@Column(name = "fechaEmiComp", nullable = false)
	public Date fechaEmiComp; //21/01/2021
	@Column(name = "direccionComp", nullable = false)
	public String direccionComp;
	@Column(name = "ubigeoComp", nullable = false)
	public String ubigeoComp;
	@ManyToOne
	@JoinColumn(name="idEstCompro", referencedColumnName = "idEstCompro")
	public EstCompro idEstCompro;
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
