package com.ofsystem.Model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "pedido_id_producto")
@Data
@AllArgsConstructor
@NoArgsConstructor
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
