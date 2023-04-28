package com.ofsystem.Model;

import com.ofsystem.Enums.EtiquetaName;
import com.ofsystem.Enums.TallaName;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "talla")
@Data
public class Talla {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTalla;
    @Enumerated(EnumType.STRING)
    @Column(name = "identItem", nullable = false)
    private TallaName identItem;
    @Column(name = "nombreItem", nullable = true)
    private  String nombreItem;

    @Column(name = "abreviItem", nullable = false)
    private  String abreviItem;

    @Column(name = "vistaItem", nullable = true)
    private  String vistaItem;

    public Talla(TallaName ident) {
        this.identItem = ident;
        this.abreviItem = ident.getAbreviatura();
        this.nombreItem = ident.getValue();
        this.vistaItem = ident.getVista();
    }
    public Talla() {
    }
}


