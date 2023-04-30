package com.ofsystem.Model;

import com.ofsystem.Enums.EtiquetaName;
import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name = "etiquetas")
@Data
public class Etiquetas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEtiqueta;
    @Enumerated(EnumType.STRING)
    @Column(name = "identItem", nullable = false)
    private EtiquetaName identItem;
    @Column(name = "nombreItem", nullable = true)
    private  String nombreItem;

    @Column(name = "abreviItem", nullable = false)
    private  String abreviItem;

    @Column(name = "vistaItem", nullable = true)
    private  String vistaItem;

    public Etiquetas() {
    }

    public Etiquetas(EtiquetaName ident) {
        this.identItem = ident;
        this.abreviItem = ident.getAbreviatura();
        this.nombreItem = ident.getValue();
        this.vistaItem = ident.getVista();
    }
}

