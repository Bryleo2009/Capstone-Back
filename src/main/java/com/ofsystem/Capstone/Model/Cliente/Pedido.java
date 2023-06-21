package com.ofsystem.Capstone.Model.Cliente;

import javax.persistence.*;

import com.ofsystem.Capstone.Model.Comprobante.Comprobante;
import com.ofsystem.Capstone.Model.Comprobante.Detalle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "pedido")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idPedido;
    @Column(name = "fechaPedido", nullable = false)
    public Date fechaPedido;
    @Column(name="observacionesPedido", nullable = true)
    public String observacionesPedido;/////
    @Column(name="cantidadTotalPedido", nullable = false)
    public int cantidadTotalPedido; /////
    @Column(name="nombreRecojoPedido", nullable = false)
    public String nombreRecojoPedido;
    @Column(name="apellidoRecojoPedido", nullable = false)
    public String apellidoRecojoPedido;
    @Column(name="celularRecojoPedido", nullable = false)
    public String celularRecojoPedido;
    @Column(name="correoRecojoPedido", nullable = false)
    public String correoRecojoPedido;
    @Column(name="direccionRecojoPedido", nullable = false)
    public String direccionRecojoPedido;
    @OneToOne
    @JoinColumn(name="idComp", referencedColumnName = "idComp")
    public Comprobante idComp;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "pedido_detalle",
            joinColumns = @JoinColumn(name = "idPedido"),
            inverseJoinColumns = @JoinColumn(name = "idDetalle")
    )
    public List<Detalle> idDetalle;

    public int cantidadTotal (List<Detalle> detalleList){
        int cant = 0;
        for (Detalle detalle : detalleList){
            cant += detalle.getCantProductDetalle();
        }
        return cant;
    }

    public void agregarDetalle(List<Detalle> nuevosDetalles) {
        if (idDetalle == null) {
            idDetalle = new ArrayList<>();
        }
        idDetalle.addAll(nuevosDetalles);
        for (Detalle detalle : nuevosDetalles) {
            detalle.setPedido(this);
        }
    }
}
