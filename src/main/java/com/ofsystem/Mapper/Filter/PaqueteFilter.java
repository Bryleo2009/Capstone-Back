package com.ofsystem.Mapper.Filter;

import com.ofsystem.Model.Cliente.PaqueteProductos;
import com.ofsystem.Model.Usuario.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaqueteFilter {
    public List<CarritoFilter> paqueteProductos;
    public Cliente cliente;
}
