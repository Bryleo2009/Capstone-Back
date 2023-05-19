package com.ofsystem.Model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "pedido")
@Data
@AllArgsConstructor
@NoArgsConstructor
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
    @JoinColumn(name="idCliente", referencedColumnName = "id")
    public Cliente idCliente;
    @ManyToOne
    @JoinColumn(name="idEstProduct", referencedColumnName = "idEstProduct")
    public EstProduct idEstProduct;
}
