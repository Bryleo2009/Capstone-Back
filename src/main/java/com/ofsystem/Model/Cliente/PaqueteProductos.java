package com.ofsystem.Model.Cliente;

import javax.persistence.*;

import com.ofsystem.Model.Producto.Producto;
import com.ofsystem.Model.Usuario.Cliente;
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
    private int id;
    @ManyToOne
    @JoinColumn(name = "producto_id_product")
    private Producto producto_id_product;
    @Column(name = "cantProduct", nullable = false)
    public int cantProduct;
    @ManyToOne
    @JoinColumn(name="idCliente", referencedColumnName = "id")
    private Cliente idCliente;



}
