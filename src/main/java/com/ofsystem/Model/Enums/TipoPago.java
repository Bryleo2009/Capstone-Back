package com.ofsystem.Model.Enums;

import com.ofsystem.Model.Enums.Name.TipoPagoName;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;


@Entity
@Table (name = "tipoPago")
@Data
@AllArgsConstructor
public class TipoPago {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int idTp;
    @Enumerated(EnumType.STRING)
    @Column(name = "identItem", nullable = false)
    private TipoPagoName identItem;
    @Column(name = "nombreItem", nullable = true)
    private  String nombreItem;

    @Column(name = "abreviItem", nullable = false)
    private  String abreviItem;

    @Column(name = "vistaItem", nullable = true)
    private  String vistaItem;

    public TipoPago() {
    }

    public TipoPago(TipoPagoName ident) {
        this.identItem = ident;
        this.abreviItem = ident.getAbreviatura();
        this.nombreItem = ident.getValue();
        this.vistaItem = ident.getVista();
    }

}
