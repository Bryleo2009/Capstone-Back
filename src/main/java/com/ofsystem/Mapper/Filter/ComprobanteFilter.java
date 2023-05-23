package com.ofsystem.Mapper.Filter;

import com.ofsystem.Model.Cliente;
import com.ofsystem.Model.TipoCompro;
import com.ofsystem.Model.Trabajador;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComprobanteFilter {

    public Cliente cliente;
    public List<CarritoFilter> carritoFilterList;//me sobra
    public double montoProducto;
    public double igv;//me sobra
    public double ammount;
    public String direccionComp;
    public String ubigeoComp;
    public boolean idTc;

    public Trabajador trabajador;

}
