package com.ofsystem.Model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Random;

@Entity
@Table (name = "producto")
@Data
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int idProduct;
	@Column(name = "iup", nullable = false, length = 1000)
	public String IUP;
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
	public String rutaQr;
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

	public void setIUP() {
		this.IUP = generarIUP(nombreProduct,idCateg.getIdCateg(),idMarca.getIdMarca(),idTipoProduc.getIdTipoProduc());
	}

	public String generarIUP(String nombreProduct, int idCateg, int idMarca, int idTipoProduc) {
		Random random = new Random();
		int randomNumber = random.nextInt(999); // genera un número aleatorio entre 0 y 999
		String nombreProductoSinEspacios = nombreProduct.replaceAll("\\s", "").toUpperCase();
		String primeras2 = nombreProductoSinEspacios.substring(0, 2);
		char terceraLetra = nombreProductoSinEspacios.charAt(2);
		char ultimaLetra = nombreProductoSinEspacios.charAt(nombreProductoSinEspacios.length() - 1);
		String iup = primeras2 + '-' + 'C' + idCateg + 'M' + idMarca + "TP" + idTipoProduc + '-' +
				terceraLetra + '-' + String.format("%03d", randomNumber) + '-' + ultimaLetra;
		return iup;
	}

}
