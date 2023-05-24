package com.ofsystem.Model.Cliente;

import java.util.List;

import javax.persistence.*;

import com.ofsystem.Model.Producto.Producto;
import com.ofsystem.Model.Usuario.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;


@Entity
@Table (name = "listadeseo")
@Data
@AllArgsConstructor
public class ListaDeseos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idListaDeseo;

    @ManyToMany
    @JoinColumn(name="idProduct", referencedColumnName = "idProduct")
    public List<Producto> idProduct;

    @ManyToOne
    @JoinColumn(name="idCliente", referencedColumnName = "id")
    public Cliente idCliente;

    public ListaDeseos() {

    }
}