package com.ofsystem.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table (name = "producto")
@Data
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int idProduct;
	@Column(name = "descripcionProduct", nullable = false, length = 500)
    @Size(min = 3, message = "Minimo 3 caracteres")
	public String descripcionProduct;
	@Column(name = "precioUni", nullable = false)
	public double precioUni;
	@Column(name = "stockProduct", nullable = false)
	public int stockProduct;
	@Column(name = "tallaProduct", nullable = false, length = 20)
    @Size(min = 1, message = "Minimo 1 caracteres")
	public String tallaProduct;
	public String imagen;

	@ManyToOne
    @JoinColumn(name="idCateg", referencedColumnName = "idCateg")
	public Categoria idCateg;

	
	
}
