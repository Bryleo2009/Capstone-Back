package com.ofsystem.Mapper.Filter;

import com.ofsystem.Model.Producto.Producto;
import com.ofsystem.Model.Usuario.Cliente;
import com.ofsystem.Model.Usuario.Trabajador;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListadeseoFilter {
     public int id_lista_deseo;
     public Date fecha_lista_deseo;
     public int  idCliente_listadeseo;
     public Producto id_product;
     public Producto nombre_product;

     public Producto imagen;

     public Cliente id;

     public Cliente apellido;


}
