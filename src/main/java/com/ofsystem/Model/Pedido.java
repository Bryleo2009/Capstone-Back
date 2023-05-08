package com.ofsystem.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "pedido")
@Data
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idPedido;

    @ManyToMany
    @JoinTable(
            name = "idPedido",
            joinColumns = @JoinColumn(name = "idProduct"),
            inverseJoinColumns = @JoinColumn(name = "idPedido"))
    public List<Producto> idProduct;

    @Column(name="cantidad", nullable = false)
    public int cantidad;

    @ManyToOne
    @JoinColumn(name="idComp", referencedColumnName = "idComp")
    public Comprobante idComp;

    @ManyToOne
    @JoinColumn(name="idCliente", referencedColumnName = "idCliente")
    public Cliente idCliente;

    @ManyToOne
    @JoinColumn(name="idEstEnvioProduct", referencedColumnName = "idEstEnvioProduct")
    public EstProduct idEstProduct;
}
