package com.ofsystem.Capstone.Service.Service.Cliente;

import com.ofsystem.Capstone.Mapper.Filter.SeguimientoListadeseosFilter;
import com.ofsystem.Capstone.Model.Cliente.ListaDeseos;
import com.ofsystem.Capstone.Service.Service.ICRUDService;

import java.util.List;

public interface IListaDeseoService extends ICRUDService<ListaDeseos, Integer> {
    ListaDeseos findByIdComp_Iuc(String iuc);

    ListaDeseos findByIdComp_IdComp (String idComp);

    List<SeguimientoListadeseosFilter> listarListadeseo (int idUser);
}
