package com.ofsystem.Service.Service.Cliente;

import com.ofsystem.Mapper.Filter.*;
import com.ofsystem.Model.Cliente.ListaDeseos;
import com.ofsystem.Model.Cliente.Pedido;
import com.ofsystem.Service.Service.ICRUDService;

import java.util.List;

public interface IListaDeseoService extends ICRUDService<ListaDeseos, Integer> {

    List<ListadeseoFilter> listarListadeseos (int idCli);


}
