package com.ofsystem.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "producto_id_talla")
@Data
public class ProductoTalla {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "producto_id_product")
    private Producto producto_id_product;
    @ManyToOne
    @JoinColumn(name = "id_talla_id_talla")
    private Talla id_talla_id_talla;
    @Column(name = "stockRealProduct", nullable = false)
    public int stockRealProduct;
    @Column(name = "stockComproProduct", nullable = false)
    public int stockComproProduct;

    public void setStock(int stockReal, int stockCompro) {
        this.stockRealProduct = stockReal;
        this.stockComproProduct = stockCompro;
    }
}
