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
@Table (name = "detalleComprobante")
@Data
public class Detalle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int idDcomp;
	@Column(name = "cantProductDetalle", nullable = false)
	public int cantProductDetalle; //10
	@Column(name = "precioUniDetalle", nullable = false)
	public double precioUniDetalle; //0.20
	@Column(name = "precioTotalDetalle", nullable = false)
	public double precioTotalDetalle; //2.00
	@Column(name = "productoDetalle", nullable = false)
	public String productoDetalle;
	@Column(name = "idProduct", nullable = true)
	public int idProduct;
	public String imagen;
	@ManyToOne
    @JoinColumn(name="idComp", referencedColumnName = "idComp")
	public Comprobante idComp;
	
	
	
	
	
	
}
