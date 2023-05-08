package com.ofsystem.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "pedido_id_producto")
@Data
public class PedidoProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "producto_id_product")
    private Producto producto_id_product;

    @Column(name = "cantProduct", nullable = false)
    public int cantProduct;
}
