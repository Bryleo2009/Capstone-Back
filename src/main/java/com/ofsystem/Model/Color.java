package com.ofsystem.Model;

import com.ofsystem.Enums.ColorName;
import com.ofsystem.Enums.EtiquetaName;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "colores")
@Data
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idColor;
    @Enumerated(EnumType.STRING)
    @Column(name = "identItem", nullable = false)
    private ColorName identItem;
    @Column(name = "nombreItem", nullable = true)
    private  String nombreItem;

    @Column(name = "abreviItem", nullable = false)
    private  String abreviItem;

    @Column(name = "vistaItem", nullable = true)
    private  String vistaItem;

    public Color() {
    }

    public Color(ColorName ident) {
        this.identItem = ident;
        this.abreviItem = ident.getAbreviatura();
        this.nombreItem = ident.getValue();
        this.vistaItem = ident.getVista();
    }
}
