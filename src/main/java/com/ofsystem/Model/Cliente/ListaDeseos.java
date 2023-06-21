/*package com.ofsystem.Model.Cliente;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.ofsystem.Model.Comprobante.Comprobante;
import com.ofsystem.Model.Comprobante.Detalle;
import com.ofsystem.Model.Producto.Producto;
import com.ofsystem.Model.Usuario.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table (name = "listadeseo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListaDeseos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idListaDeseo;
    @Column(name = "fechaListaDeseo", nullable = false)
    public Date fechaListaDeseo;
    @Column(name="observacionesListaDeseo", nullable = true)
    public String observacionesListaDeseo;/////
    @Column(name="cantidadTotalListaDeseo", nullable = false)
    public int cantidadTotalListaDeseo; /////
    @Column(name="nombreRecojoListaDeseo", nullable = false)
    public String nombreRecojoListaDeseo;
    @Column(name="apellidoRecojoListaDeseo", nullable = false)
    public String apellidoRecojoListaDeseo;
    @Column(name="celularRecojoListaDeseo", nullable = false)
    public String celularRecojoListaDeseo;
    @Column(name="correoRecojoListaDeseo", nullable = false)
    public String correoRecojoListaDeseo;
    @Column(name="direccionRecojoListaDeseo", nullable = false)
    public String direccionRecojoListaDeseo;
    @OneToOne
    @JoinColumn(name="idComp", referencedColumnName = "idComp")
    public Comprobante idComp;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "listadeseo_detalle",
            joinColumns = @JoinColumn(name = "idListaDeseo"),
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
            detalle.setListaDeseos(this);
        }
    }
}
*/