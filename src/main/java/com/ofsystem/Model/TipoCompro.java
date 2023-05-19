package com.ofsystem.Model;


import com.ofsystem.Enums.EtiquetaName;
import com.ofsystem.Enums.TipoComproName;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "tipoCompro")
@Data
@AllArgsConstructor
public class TipoCompro {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idTc;
    @Enumerated(EnumType.STRING)
    @Column(name = "identItem", nullable = false)
    private TipoComproName identItem;
    @Column(name = "nombreItem", nullable = true)
    private  String nombreItem;

    @Column(name = "abreviItem", nullable = false)
    private  String abreviItem;

    @Column(name = "vistaItem", nullable = true)
    private  String vistaItem;

    public TipoCompro() {
    }

    public TipoCompro(TipoComproName ident) {
        this.identItem = ident;
        this.abreviItem = ident.getAbreviatura();
        this.nombreItem = ident.getValue();
        this.vistaItem = ident.getVista();
    }

	
}
