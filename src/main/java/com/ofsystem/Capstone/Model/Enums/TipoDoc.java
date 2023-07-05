package com.ofsystem.Capstone.Model.Enums;


import com.ofsystem.Capstone.Model.Enums.Name.TipoDocName;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;


@Entity
@Table (name = "tipoDoc")
@Data
@AllArgsConstructor
public class TipoDoc {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idTipoDoc;
    @Enumerated(EnumType.STRING)
    @Column(name = "identItem", nullable = false)
    private TipoDocName identItem;
    @Column(name = "nombreItem", nullable = true)
    private  String nombreItem;

    @Column(name = "abreviItem", nullable = false)
    private  String abreviItem;

    @Column(name = "vistaItem", nullable = true)
    private  String vistaItem;

    public TipoDoc() {
    }

    public TipoDoc(TipoDocName ident) {
        this.identItem = ident;
        this.abreviItem = ident.getAbreviatura();
        this.nombreItem = ident.getValue();
        this.vistaItem = ident.getVista();
    }

	
}