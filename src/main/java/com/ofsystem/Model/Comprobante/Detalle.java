package com.ofsystem.Model.Comprobante;


import javax.persistence.*;

import com.ofsystem.Model.Cliente.Pedido;
import com.ofsystem.Model.Enums.TipoCompro;
import com.ofsystem.Model.Enums.TipoPago;
import com.ofsystem.Model.Producto.Producto;
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
	public int idDetalle;
	@Column(name = "cantProductDetalle", nullable = false)
	public int cantProductDetalle; //10
	@Column(name = "precioUniDetalle", nullable = false)
	public double precioUniDetalle; //0.20
	@Column(name = "precioTotalDetalle", nullable = false)
	public double precioTotalDetalle; //2.00
	@Column(name = "productoDetalle", nullable = false)
	public String productoDetalle;
	@OneToOne
	@JoinColumn(name="idProduct", referencedColumnName = "idProduct")
	public Producto idProduct;
	@OneToOne
    @JoinColumn(name="idComp", referencedColumnName = "idComp")
	public Comprobante idComp;
	@Column(name = "precioDescuentoDetalle", nullable = true)
	public Double precioDescuentoDetalle; //2.00
	@ManyToOne
	@JoinColumn(name = "id_pedido")
	private Pedido pedido;

	public Detalle(int cantProductDetalle, double precioUniDetalle, double precioTotalDetalle, String productoDetalle, Producto idProduct, Comprobante idComp, Double precioDescuentoDetalle) {
		this.cantProductDetalle = cantProductDetalle;
		this.precioUniDetalle = precioUniDetalle;
		this.precioTotalDetalle = precioTotalDetalle;
		this.productoDetalle = productoDetalle;
		this.idProduct = idProduct;
		this.idComp = idComp;
		this.precioDescuentoDetalle = precioDescuentoDetalle;
	}
}
