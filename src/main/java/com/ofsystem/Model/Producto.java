package com.ofsystem.Model;


import jakarta.persistence.*;
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
	@Column(name = "isPrecioDescProduct", nullable = false)
	public boolean isPrecioDescProduct;
	@Column(name = "precioDescuProduct", nullable = true)
	public Double precioDescuProduct;
	public String imagen;
	@ManyToOne
    @JoinColumn(name="idCateg", referencedColumnName = "idCateg")
	public Categoria idCateg;
	@ManyToOne
	@JoinColumn(name="idTipoProduc", referencedColumnName = "idTipoProduc")
	public TipoProducto idTipoProduc;

	@ManyToMany
	@JoinColumn(name="idEtiqueta", referencedColumnName = "idEtiqueta")
	public List<Etiquetas> idEtiqueta;

	@ManyToMany
	@JoinColumn(name="idTalla", referencedColumnName = "idTalla")
	public List<Talla> idTalla;

	public Producto() {

	}

	public Producto(String descripcionProduct, String nombreProduct, double precioUni, int stockProduct, boolean isPrecioDescProduct, double precioDescuProduct, String imagen, Categoria idCateg, TipoProducto idTipoProduc, List<Etiquetas> idEtiqueta, List<Talla> idTalla) {
		this.descripcionProduct = descripcionProduct;
		this.nombreProduct = nombreProduct;
		this.precioUni = precioUni;
		this.stockProduct = stockProduct;
		this.isPrecioDescProduct = isPrecioDescProduct;
		this.precioDescuProduct = precioDescuProduct;
		this.imagen = imagen;
		this.idCateg = idCateg;
		this.idTipoProduc = idTipoProduc;
		this.idEtiqueta = idEtiqueta;
		this.idTalla = idTalla;
	}
}
