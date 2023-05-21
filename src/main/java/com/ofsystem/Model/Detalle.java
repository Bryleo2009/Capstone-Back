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
@Table (name = "detalleComprobante")
@Data
@AllArgsConstructor
@NoArgsConstructor
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

	@Column(name = "precioDescuento", nullable = true)
	public Double precioDescuento; //2.00

}
