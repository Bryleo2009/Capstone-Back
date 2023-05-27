package com.ofsystem.Service.Service.Cliente;

import com.ofsystem.Model.Cliente.Pedido;
import com.ofsystem.Service.Service.ICRUDService;

public interface IPedidoService extends ICRUDService<Pedido, Integer> {
    Pedido findByIdComp_Iuc(String iuc);

    Pedido findByIdComp_IdComp (String idComp);
}
