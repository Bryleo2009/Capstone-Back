package com.ofsystem.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "trazaPedidos")
@Data
public class TrazabilidadPedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idTrazaPedidos;

    @ManyToOne
    @JoinColumn(name ="idPedido", referencedColumnName = "idPedido")
    public Pedido idPedido;

    @ManyToOne
    @JoinColumn(name="idProceActual", referencedColumnName = "idEstEnvioProduct")
    public EstEnvioProduct idProceActual;

    @ManyToOne
    @JoinColumn(name="idProceAnterior", referencedColumnName = "idEstEnvioProduct")
    public EstEnvioProduct idProceAnterior;

    @Column(name="fechaIniProc", nullable = false)
    public Date fechaIniProc;

    @Column(name="fechaFinProc", nullable = false)
    public Date fechaFinProc;

    @Column (name="Observac", nullable = true)
    public String Observac;

    @ManyToOne
    @JoinColumn(name="idCliente",referencedColumnName = "idCliente")
    public Cliente idCliente;

    @ManyToOne
    @JoinColumn(name="idTraba",referencedColumnName = "idTraba")
    public Trabajador idTraba;

}
