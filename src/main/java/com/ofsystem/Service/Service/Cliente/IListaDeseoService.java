package com.ofsystem.Service.Service.Cliente;

import com.ofsystem.Mapper.Filter.SeguimientoListadeseosFilter;
import com.ofsystem.Mapper.Filter.SeguimientoPedidoFilter;
import com.ofsystem.Model.Cliente.ListaDeseos;
import com.ofsystem.Model.Cliente.Pedido;
import com.ofsystem.Service.Service.ICRUDService;

import java.util.List;

public interface IListaDeseoService extends ICRUDService<ListaDeseos, Integer> {
    ListaDeseos findByIdComp_Iuc(String iuc);

    ListaDeseos findByIdComp_IdComp (String idComp);

    List<SeguimientoListadeseosFilter> listarListadeseo (int idUser);
}
