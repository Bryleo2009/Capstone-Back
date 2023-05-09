package com.ofsystem.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "trazaCompro")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrazabilidadComprobantes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idTrazaCompro;

    @ManyToOne
    @JoinColumn(name="idComp", referencedColumnName = "idComp")
    public Comprobante idComp;

    @ManyToOne
    @JoinColumn(name="idProceActual", referencedColumnName = "idEstCompro")
    public EstCompro idProceActual;

    @ManyToOne
    @JoinColumn(name="idProceAnterior", referencedColumnName = "idEstCompro")
    public EstCompro idProceAnterior;

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
