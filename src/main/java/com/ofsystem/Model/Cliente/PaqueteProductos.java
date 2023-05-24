package com.ofsystem.Model.Cliente;

import javax.persistence.*;

import com.ofsystem.Model.Producto.Producto;
import com.ofsystem.Model.Usuario.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Entity
@Table(name = "paquete_pedido")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaqueteProductos {
    /**
     * !mala asignacion de relacion
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "producto_id_product")
    private Producto producto_id_product;
    @Column(name = "cantProduct", nullable = false)
    public int cantProduct;
    @ManyToOne
    @JoinColumn(name="idCliente", referencedColumnName = "id")
    private Cliente idCliente;
    @Column(name = "fechaPedidoProduc", nullable = false)
    public Date fechaPedidoProduc; //21/01/2021

    public PaqueteProductos(Producto producto_id_product, int cantProduct, Cliente idCliente, Date fechaPedidoProduc) {
        this.producto_id_product = producto_id_product;
        this.cantProduct = cantProduct;
        this.idCliente = idCliente;
        this.fechaPedidoProduc = fechaPedidoProduc;
    }
}
