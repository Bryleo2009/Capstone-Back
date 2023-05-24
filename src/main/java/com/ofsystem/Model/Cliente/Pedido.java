package com.ofsystem.Model;

import javax.persistence.*;

import com.ofsystem.Model.Enums.EstProduct;
import com.ofsystem.Model.Usuario.Cliente;
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
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "idPedido"))
    public List<PedidoProducto> idProduct;
    @Column(name="observaciones", nullable = false)
    public String observaciones;
    @Column(name="cantidadTotal", nullable = false)
    public int cantidadTotal;
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
