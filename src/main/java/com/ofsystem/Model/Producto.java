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

import java.util.List;

@Entity
@Table (name = "producto")
@Data
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int idProduct;
	@Column(name = "descripcionProduct", nullable = false, length = 1000)
	public String descripcionProduct;
	@Column(name = "nombreProduct", nullable = false, length = 1000)
	public String nombreProduct;
	@Column(name = "precioUni", nullable = false)
	public double precioUni;
	@Column(name = "stockProduct", nullable = false)
	public int stockProduct;
	@Column(name = "tallaProduct", nullable = false, length = 1000)
	public String tallaProduct;
	@Column(name = "etiquetasProduct", nullable = false, length = 10000)
	public String etiquetas;
	@Column(name = "isPrecioDescProduct", nullable = false)
	public boolean isPrecioDescProduct;
	@Column(name = "precioDescuProduct", nullable = true)
	public double precioDescuProduct;
	public String imagen;
	@ManyToOne
    @JoinColumn(name="idCateg", referencedColumnName = "idCateg")
	public Categoria idCateg;
	@ManyToOne
	@JoinColumn(name="idTipoProduc", referencedColumnName = "idTipoProduc")
	public TipoProducto idTipoProduc;

}
