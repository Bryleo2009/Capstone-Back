package com.ofsystem.Model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
