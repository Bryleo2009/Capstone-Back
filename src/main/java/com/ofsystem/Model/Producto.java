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
	@JoinTable(
			name = "idTalla",
			joinColumns = @JoinColumn(name = "idProduct"),
			inverseJoinColumns = @JoinColumn(name = "idTalla"))
	public List<Talla> idTalla;
	@ManyToMany
	@JoinColumn(name="idColor", referencedColumnName = "idColor")
	public List<Color> idColor;
	@Column(name = "isExistente", nullable = false)
	public boolean isExistente;
	public Producto() {

	}


}
