package com.ofsystem.Model.Enums;

import com.ofsystem.Model.Enums.Name.MarcaName;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;


@Entity
@Table(name = "marcas")
@Data
@AllArgsConstructor
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMarca;
    @Enumerated(EnumType.STRING)
    @Column(name = "identItem", nullable = false)
    private MarcaName identItem;
    @Column(name = "nombreItem", nullable = true)
    private  String nombreItem;

    @Column(name = "abreviItem", nullable = false)
    private  String abreviItem;

    @Column(name = "vistaItem", nullable = true)
    private  String vistaItem;

    public Marca() {
    }

    public Marca(MarcaName ident) {
        this.identItem = ident;
        this.abreviItem = ident.getAbreviatura();
        this.nombreItem = ident.getValue();
        this.vistaItem = ident.getVista();
    }
}
