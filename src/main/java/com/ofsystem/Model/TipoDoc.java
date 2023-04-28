package com.ofsystem.Model;


import com.ofsystem.Enums.TipoDocName;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table (name = "tipoDoc")
@Data
public class TipoDoc {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idTdoc;
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
