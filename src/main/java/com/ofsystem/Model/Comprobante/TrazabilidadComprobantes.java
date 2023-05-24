package com.ofsystem.Model.Comprobante;

import javax.persistence.*;

import com.ofsystem.Model.Enums.EstCompro;
import com.ofsystem.Model.Usuario.Cliente;
import com.ofsystem.Model.Usuario.Trabajador;
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
    @ManyToOne(optional = true)
    @JoinColumn(name="idProceAnterior", referencedColumnName = "idEstCompro")
    public EstCompro idProceAnterior;
    @Column(name="fechaIniProc", nullable = false)
    public Date fechaIniProc;
    @Column(name="fechaFinProc", nullable = true)
    public Date fechaFinProc;
    @Column (name="Observac", nullable = true)
    public String Observac;
    @ManyToOne
    @JoinColumn(name="idTraba",referencedColumnName = "id")
    public Trabajador idTraba;

}
