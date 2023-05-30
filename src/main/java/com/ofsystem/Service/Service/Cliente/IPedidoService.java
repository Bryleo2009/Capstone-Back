package com.ofsystem.Service.Service.Cliente;

import com.ofsystem.Mapper.Filter.SeguimientoPedidoFilter;
import com.ofsystem.Model.Cliente.Pedido;
import com.ofsystem.Service.Service.ICRUDService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IPedidoService extends ICRUDService<Pedido, Integer> {
    Pedido findByIdComp_Iuc(String iuc);

    Pedido findByIdComp_IdComp (String idComp);

    List<SeguimientoPedidoFilter> listarPedido (int idUser);
}
