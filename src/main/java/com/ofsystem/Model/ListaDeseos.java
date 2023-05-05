package com.ofsystem.Model;

import java.util.Date;
import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table (name = "listadeseo")
@Data
public class ListaDeseos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idListaDeseo;

    @ManyToOne
    @JoinColumn(name="idProduct", referencedColumnName = "idProduct")
    public Producto idProduct;

    @ManyToOne
    @JoinColumn(name="idCliente", referencedColumnName = "idCliente")
    public Cliente idCliente;

    public ListaDeseos() {

    }
    public ListaDeseos(int idListaDeseo, Producto idProduct, Cliente idCliente) {
        this.idListaDeseo = idListaDeseo;
        this.idProduct = idProduct;
        this.idCliente = idCliente;
    }
}
