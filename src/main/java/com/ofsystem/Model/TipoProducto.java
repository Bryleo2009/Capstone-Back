package com.ofsystem.Model;

import com.ofsystem.Enums.CategoriaName;
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
    @Column(name = "nombreTipoProduc", nullable = false, length = 1000)
    public TipoProductoName nombreTipoProduc;

    public TipoProducto() {

    }

    public TipoProducto(TipoProductoName nombreTipoProduc) {
        this.nombreTipoProduc = nombreTipoProduc;
    }
}
