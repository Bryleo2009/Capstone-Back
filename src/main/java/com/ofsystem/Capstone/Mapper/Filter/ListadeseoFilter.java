package com.ofsystem.Capstone.Mapper.Filter;

import com.ofsystem.Capstone.Model.Usuario.Trabajador;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListadeseoFilter {
    public PaqueteFilter idProduct;
    public Date fechaCompra;
    public String nombreRecojo;
    public String apellidoRecojo;
    public String celularRecojo;
    public String correoRecojo;
    public String direccionRecojo;
    public Trabajador idTraba;
}
