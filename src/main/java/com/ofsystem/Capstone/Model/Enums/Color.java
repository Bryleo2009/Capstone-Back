package com.ofsystem.Capstone.Model.Enums;

import com.ofsystem.Capstone.Model.Enums.Name.ColorName;

import javax.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Data;


@Entity
@Table(name = "color")
@Data
@AllArgsConstructor
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
