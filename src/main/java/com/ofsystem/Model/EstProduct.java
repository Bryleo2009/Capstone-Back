package com.ofsystem.Model;

import com.ofsystem.Enums.EstProductName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "estProduct")
@Data
@AllArgsConstructor
public class EstProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idEstProduct;
    @Enumerated(EnumType.STRING)
    @Column(name = "identItem", nullable = false)
    private EstProductName identItem;
    @Column(name = "nombreItem", nullable = true)
    private  String nombreItem;

    @Column(name = "abreviItem", nullable = false)
    private  String abreviItem;

    @Column(name = "vistaItem", nullable = true)
    private  String vistaItem;

    public EstProduct() {
    }

    public EstProduct(EstProductName ident) {
        this.identItem = ident;
        this.abreviItem = ident.getAbreviatura();
        this.nombreItem = ident.getValue();
        this.vistaItem = ident.getVista();
    }

}
