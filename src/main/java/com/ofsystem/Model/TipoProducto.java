package com.ofsystem.Model;

import com.ofsystem.Enums.CategoriaName;
import com.ofsystem.Enums.EtiquetaName;
import com.ofsystem.Enums.TipoProductoName;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tipo_producto")
@Data
public class TipoProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idTipoProduc;
    @Enumerated(EnumType.STRING)
    @Column(name = "identItem", nullable = false)
    private TipoProductoName identItem;
    @Column(name = "nombreItem", nullable = false)
    private  String nombreItem;

    @Column(name = "abreviItem", nullable = false)
    private  String abreviItem;

    public TipoProducto() {

    }

    public TipoProducto(TipoProductoName ident) {
        this.identItem = ident;
        this.abreviItem = ident.getAbreviatura();
        this.nombreItem = ident.getValue();
    }
}
