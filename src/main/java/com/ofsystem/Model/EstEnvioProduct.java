package com.ofsystem.Model;

import com.ofsystem.Enums.EstComproName;
import com.ofsystem.Enums.EstEnvioProductName;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "estEnvioProduct")
@Data
public class EstEnvioProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idEstEnvioProduct;
    @Enumerated(EnumType.STRING)
    @Column(name = "identItem", nullable = false)
    private EstEnvioProductName identItem;
    @Column(name = "nombreItem", nullable = true)
    private  String nombreItem;

    @Column(name = "abreviItem", nullable = false)
    private  String abreviItem;

    @Column(name = "vistaItem", nullable = true)
    private  String vistaItem;

    public EstEnvioProduct() {
    }

    public EstEnvioProduct(EstEnvioProductName ident) {
        this.identItem = ident;
        this.abreviItem = ident.getAbreviatura();
        this.nombreItem = ident.getValue();
        this.vistaItem = ident.getVista();
    }

}
