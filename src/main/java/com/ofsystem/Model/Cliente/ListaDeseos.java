package com.ofsystem.Model.Cliente;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.ofsystem.Model.Comprobante.Detalle;
import com.ofsystem.Model.Producto.Producto;
import com.ofsystem.Model.Usuario.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "listadeseo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListaDeseos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idListaDeseo;

    @Column(name = "fechaListaDeseo", nullable = false)
    public Date fechaListaDeseo;

    @Column(name = "observacionesListaDeseo", nullable = true)
    public String observacionesListaDeseo;

    @ManyToOne
    @JoinColumn(name = "id")
    public Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "idProduct")
    public Producto producto;

}