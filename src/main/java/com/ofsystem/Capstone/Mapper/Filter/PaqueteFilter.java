package com.ofsystem.Capstone.Mapper.Filter;

import com.ofsystem.Capstone.Model.Usuario.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaqueteFilter {
    public List<ProductoStorage> paqueteProductos;
    public Cliente cliente;
}
