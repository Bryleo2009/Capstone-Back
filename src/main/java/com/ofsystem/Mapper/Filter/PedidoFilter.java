package com.ofsystem.Mapper.Filter;

import com.ofsystem.Model.Cliente.PaqueteProductos;
import com.ofsystem.Model.Comprobante.Comprobante;
import com.ofsystem.Model.Usuario.Trabajador;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoFilter {
    public PaqueteFilter idProduct;
    public Date fechaCompra;
    public String nombreRecojo;
    public String apellidoRecojo;
    public String celularRecojo;
    public String correoRecojo;
    public String direccionRecojo;
    public Trabajador idTraba;
}
