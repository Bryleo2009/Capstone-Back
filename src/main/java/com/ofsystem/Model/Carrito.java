package com.ofsystem.Model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "carrito")
@Data
@AllArgsConstructor
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
    @Column(name = "isPedidoAct", nullable = false)
    public boolean isPedidoAct;
    @ManyToOne
    @JoinColumn(name="idProduct", referencedColumnName = "idProduct")
    public Producto idProduct;

    @ManyToOne
    @JoinColumn(name="idCliente", referencedColumnName = "idCliente")
    public Cliente idCliente;

    @ManyToOne
    @JoinColumn(name="idTalla", referencedColumnName = "idTalla")
    public Talla idTalla;

    @ManyToOne
    @JoinColumn(name="idColor", referencedColumnName = "idColor")
    public Color idColor;

    public Carrito() {

    }

}
