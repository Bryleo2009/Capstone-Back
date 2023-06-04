package com.ofsystem.Mapper.Filter;

import com.ofsystem.Model.Producto.Producto;
import com.ofsystem.Model.Usuario.Cliente;
import com.ofsystem.Model.Usuario.Trabajador;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListadeseoFilter {
    public int idListaDeseo;
    public Date fechaListaDeseo;
    public String observacionesListaDeseo;

    public Cliente id;

    public Producto idProduct;
}
