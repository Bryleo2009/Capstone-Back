package com.ofsystem.Model.Enums;

import com.ofsystem.Model.Enums.Name.EstPedidoName;
import javax.persistence.*;

import com.ofsystem.Model.Enums.Name.RolName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "estProduct")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstPedido{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idEstPedido;
    @Enumerated(EnumType.STRING)
    @Column(name = "identItem", nullable = false)
    private EstPedidoName identItem;
    @Column(name = "nombreItem", nullable = true)
    private  String nombreItem;

    @Column(name = "abreviItem", nullable = false)
    private  String abreviItem;

    @Column(name = "vistaItem", nullable = true)
    private  String vistaItem;

    public EstPedido(EstPedidoName ident) {
        this.identItem = ident;
        this.abreviItem = ident.getAbreviatura();
        this.nombreItem = ident.getValue();
        this.vistaItem = ident.getVista();
    }

}
