package com.ofsystem.Model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table (name = "carrito")
@Data
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCarrito;
    @Column(name = "fechaCompraCarrito", nullable = false)
    public Date fechaCompraCarrito; //05/05/2023
    @Column(name = "cantidadCompraCarrito", nullable = false)
    public int cantidadCompraCarrito;
    @Column(name = "montoTotalCarrito", nullable = false)
    public double montoTotalCarrito;

    @ManyToOne
    @JoinColumn(name="idProduct", referencedColumnName = "idProduct")
    public Producto idProduct;

    @ManyToOne
    @JoinColumn(name="idCliente", referencedColumnName = "idCliente")
    public Cliente idCliente;

    @ManyToMany
    @JoinColumn(name="idTalla", referencedColumnName = "idTalla")
    public List<Talla> idTalla;

    @ManyToMany
    @JoinColumn(name="idColor", referencedColumnName = "idColor")
    public List<Color> idColor;

    public Carrito() {

    }
    public Carrito(int idCarrito, Date fechaCompraCarrito, int cantidadCompraCarrito, double montoTotalCarrito, Producto idProduct, Cliente idCliente, List<Talla> idTalla, List<Color> idColor) {
        this.idCarrito = idCarrito;
        this.fechaCompraCarrito = fechaCompraCarrito;
        this.cantidadCompraCarrito = cantidadCompraCarrito;
        this.montoTotalCarrito = montoTotalCarrito;
        this.idProduct = idProduct;
        this.idCliente = idCliente;
        this.idTalla = idTalla;
        this.idColor = idColor;
    }
}
