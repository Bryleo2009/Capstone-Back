package com.ofsystem.Model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table (name = "listadeseo")
@Data
public class ListaDeseos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idListaDeseo;

    @ManyToMany
    @JoinColumn(name="idProduct", referencedColumnName = "idProduct")
    public List<Producto> idProduct;

    @ManyToOne
    @JoinColumn(name="idCliente", referencedColumnName = "idCliente")
    public Cliente idCliente;

    public ListaDeseos() {

    }
}
