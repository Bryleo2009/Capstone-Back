package com.ofsystem.Model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;


@Entity
@Table(name = "producto_talla_color")
@Data
@AllArgsConstructor
public class ProductoTallaColor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProductoTallaColor;
    @ManyToOne
    @JoinColumn(name = "producto_id_product")
    private Producto producto;
    @ManyToOne
    @JoinColumn(name = "id_talla_id_talla")
    private Talla talla;
    @ManyToOne
    @JoinColumn(name = "id_color_id_color")
    private Color color;
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

    public ProductoTallaColor(Producto producto_id_product, Talla id_talla_id_talla,Color id_color_id_color, int Stock) {
        this.producto = producto_id_product;
        this.talla = id_talla_id_talla;
        this.color = id_color_id_color;
        this.existe_noexiste = true;
        setStock(Stock,Stock);
    }
}
