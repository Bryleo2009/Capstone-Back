package com.ofsystem.Capstone.Mapper.Filter;

import com.ofsystem.Capstone.Model.Usuario.Cliente;
import com.ofsystem.Capstone.Model.Usuario.Trabajador;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComprobanteFilter {

    public Cliente cliente;
    public List<ProductoFilter> productoStorageList;//
    public double montoProducto; //
    public double igv;
    public double ammount; //
    public String direccionComp;//
    public String ubigeoComp;//
    public boolean idTc;//
    public String ruc;//
    public String razonSocial;//
    public Trabajador trabajador;
    public String nombreRecojo;
    public String apellidoRecojo;
    public String celularRecojo;
    public String correoRecojo;
}
