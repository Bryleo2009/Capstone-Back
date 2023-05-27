package com.ofsystem.Model.Enums;


import com.ofsystem.Model.Enums.Name.EstComproName;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;


@Entity
@Table(name = "estCompro")
@Data
@AllArgsConstructor
public class EstCompro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idEstCompro;
    @Enumerated(EnumType.STRING)
    @Column(name = "identItem", nullable = false)
    private EstComproName identItem;
    @Column(name = "nombreItem", nullable = true)
    private  String nombreItem;

    @Column(name = "abreviItem", nullable = false)
    private  String abreviItem;

    @Column(name = "vistaItem", nullable = true)
    private  String vistaItem;

    public EstCompro() {
    }

    public EstCompro(EstComproName ident) {
        this.identItem = ident;
        this.abreviItem = ident.getAbreviatura();
        this.nombreItem = ident.getValue();
        this.vistaItem = ident.getVista();
    }

}
