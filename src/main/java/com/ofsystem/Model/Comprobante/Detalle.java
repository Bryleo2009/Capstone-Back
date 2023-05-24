package com.ofsystem.Model.Comprobante;


import javax.persistence.*;

import com.ofsystem.Model.Enums.TipoCompro;
import com.ofsystem.Model.Enums.TipoPago;
import com.ofsystem.Model.Usuario.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


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
	@Column(name = "iupProduct", nullable = true)
	public String iupProduct;
	public String imagen;
	@OneToOne
    @JoinColumn(name="idComp", referencedColumnName = "idComp")
	public Comprobante idComp;
	@Column(name = "precioDescuento", nullable = true)
	public Double precioDescuento; //2.00

	public String generarIUD (int cantProductDetalle, double precioUniDetalle, double precioTotalDetalle,  String iupProduct, Comprobante idComp, Double precioDescuento){
		String iud = "";
		iud = "CP" + cantProductDetalle + "PUT" + precioUniDetalle + "PTD" + precioTotalDetalle + "IUP" + iupProduct + "C" + idComp.getIdComp() + "PD" + precioDescuento +
				"F" + new Date().getDate() + new Date().getMonth() + new Date().getYear() + new Date().getHours() + new Date().getMinutes();
		return iud;
	}
}
