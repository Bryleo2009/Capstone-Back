package com.ofsystem.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "producto_talla_color")
@Data
public class ProductoTallaColor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProductoTallaColor;
    @ManyToOne
    @JoinColumn(name = "producto_id_product")
    private Producto producto_id_product;
    @ManyToOne
    @JoinColumn(name = "id_talla_id_talla")
    private Talla id_talla_id_talla;

    @ManyToOne
    @JoinColumn(name = "id_color_id_color")
    private Talla id_color_id_color;
    @Column(name = "stockRealProduct", nullable = false)
    public int stockRealProduct;
    @Column(name = "stockVirtualProduct", nullable = false)
    public int stockVirtualProduct;

    @Column(name = "existe_noexiste", nullable = false)
    public boolean existe_noexiste;

    public void setStock(int stockReal, int stockVirtual) {
        this.stockRealProduct = stockReal;
        this.stockVirtualProduct = stockVirtual;
    }

    public ProductoTallaColor() {
    }

    public ProductoTallaColor(Producto producto_id_product, Talla id_talla_id_talla, int Stock) {
        this.producto_id_product = producto_id_product;
        this.id_talla_id_talla = id_talla_id_talla;
        setStock(Stock,Stock);
    }
}
