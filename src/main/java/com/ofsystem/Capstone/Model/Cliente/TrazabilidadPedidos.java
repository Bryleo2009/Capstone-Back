package com.ofsystem.Capstone.Model.Cliente;

import javax.persistence.*;

import com.ofsystem.Capstone.Model.Enums.EstPedido;
import com.ofsystem.Capstone.Model.Usuario.Trabajador;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Entity
@Table(name = "trazaPedidos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrazabilidadPedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idTrazaPedidos;
    @OneToOne
    @JoinColumn(name ="idPedido", referencedColumnName = "idPedido")
    public Pedido idPedido;
    @ManyToOne
    @JoinColumn(name="idProceActual", referencedColumnName = "idEstPedido")
    public EstPedido idProceActual;
    @ManyToOne(optional = true)
    @JoinColumn(name="idProceAnterior", referencedColumnName = "idEstPedido")
    public EstPedido idProceAnterior;
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
