package com.ofsystem.Capstone.Service.Service.Cliente;

import com.ofsystem.Capstone.Mapper.Filter.SeguimientoPedidoFilter;
import com.ofsystem.Capstone.Mapper.Filter.TrazabilidadPedidoFilter;
import com.ofsystem.Capstone.Model.Cliente.Pedido;
import com.ofsystem.Capstone.Service.Service.ICRUDService;

import java.util.List;

public interface IPedidoService extends ICRUDService<Pedido, Integer> {
    Pedido findByIdComp_Iuc(String iuc);

    Pedido findByIdComp_IdComp (String idComp);

    List<SeguimientoPedidoFilter> listarPedido (int idUser);

    List<TrazabilidadPedidoFilter>TrazaPedido(int idPedido);


}
