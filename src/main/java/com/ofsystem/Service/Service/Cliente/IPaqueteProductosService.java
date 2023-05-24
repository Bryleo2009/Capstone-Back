package com.ofsystem.Service.Service.Cliente;

import com.ofsystem.Model.Cliente.PaqueteProductos;
import com.ofsystem.Model.Usuario.Cliente;
import com.ofsystem.Service.Service.ICRUDService;

import java.util.Date;
import java.util.List;

public interface IPaqueteProductosService extends ICRUDService<PaqueteProductos, Integer> {
    List<PaqueteProductos> findByIdClienteaAndAndFechaPedidoProduc (Cliente unCliente, Date unaFecha);

    int idPedido();
}
