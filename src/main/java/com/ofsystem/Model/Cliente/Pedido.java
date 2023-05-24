package com.ofsystem.Model.Cliente;

import javax.persistence.*;

import com.ofsystem.Model.Comprobante.Comprobante;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @ManyToMany
    @JoinTable(
            name = "idPedido",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "idPedido"))
    public List<PaqueteProductos> idProduct;
    @Column(name = "fechaCompra", nullable = false)
    public Date fechaCompra;
    @Column(name="observaciones", nullable = true)
    public String observaciones;/////
    @Column(name="cantidadCompra", nullable = false)
    public int cantidadCompra; /////
    @Column(name="nombreRecojo", nullable = false)
    public String nombreRecojo;
    @Column(name="apellidoRecojo", nullable = false)
    public String apellidoRecojo;
    @Column(name="celularRecojo", nullable = false)
    public String celularRecojo;
    @Column(name="correoRecojo", nullable = false)
    public String correoRecojo;
    @Column(name="direccionRecojo", nullable = false)
    public String direccionRecojo;
    @OneToOne
    @JoinColumn(name="idComp", referencedColumnName = "idComp")
    public Comprobante idComp;

    public int cantidadTotal (List<PaqueteProductos> paqueteProductos){
        int cant = 0;
        for (PaqueteProductos unPaqueteProductos : paqueteProductos){
            cant += unPaqueteProductos.getCantProduct();
        }
        return cant;
    }
}
