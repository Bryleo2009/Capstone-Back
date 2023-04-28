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
	@Column(name = "stockRealProduct", nullable = false)
	public int stockRealProduct;
	@Column(name = "stockComproProduct", nullable = false)
	public int stockComproProduct;
	@Column(name = "isPrecioDescProduct", nullable = false)
	public boolean isPrecioDescProduct;
	@Column(name = "precioDescuProduct", nullable = true)
	public Double precioDescuProduct;
	public String imagen;
	@ManyToOne
    @JoinColumn(name="idCateg", referencedColumnName = "idCateg")
	public Categoria idCateg;
	@ManyToOne
	@JoinColumn(name="idMarca", referencedColumnName = "idMarca")
	public Marca idMarca;
	@ManyToOne
	@JoinColumn(name="idTipoProduc", referencedColumnName = "idTipoProduc")
	public TipoProducto idTipoProduc;

	@ManyToMany
	@JoinColumn(name="idEtiqueta", referencedColumnName = "idEtiqueta")
	public List<Etiquetas> idEtiqueta;

	@ManyToMany
	@JoinColumn(name="idTalla", referencedColumnName = "idTalla")
	public List<Talla> idTalla;

	@ManyToMany
	@JoinColumn(name="idColor", referencedColumnName = "idColor")
	public List<Color> idColor;

	public Producto() {

	}

	public Producto(String descripcionProduct, String nombreProduct, double precioUni, int stockRealProduct, int stockComproProduct, boolean isPrecioDescProduct, Double precioDescuProduct, String imagen, Categoria idCateg, Marca idMarca, TipoProducto idTipoProduc, List<Etiquetas> idEtiqueta, List<Talla> idTalla, List<Color> idColor) {
		this.descripcionProduct = descripcionProduct;
		this.nombreProduct = nombreProduct;
		this.precioUni = precioUni;
		this.stockRealProduct = stockRealProduct;
		this.stockComproProduct = stockComproProduct;
		this.isPrecioDescProduct = isPrecioDescProduct;
		this.precioDescuProduct = precioDescuProduct;
		this.imagen = imagen;
		this.idCateg = idCateg;
		this.idMarca = idMarca;
		this.idTipoProduc = idTipoProduc;
		this.idEtiqueta = idEtiqueta;
		this.idTalla = idTalla;
		this.idColor = idColor;
	}
}
