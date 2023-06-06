package com.ofsystem.Service.Imple.Cliente;

import com.ofsystem.Mapper.Filter.*;
import com.ofsystem.Mapper.IListaDeseoMapper;
import com.ofsystem.Mapper.ITallaMapper;
import com.ofsystem.Model.Cliente.ListaDeseos;
import com.ofsystem.Model.Enums.Color;
import com.ofsystem.Repo.Cliente.IListaDeseoRepo;
import com.ofsystem.Service.Service.Cliente.IListaDeseoService;
import com.ofsystem.Service.Imple.CRUDServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListaDeseoServiceImpl extends CRUDServiceImpl<ListaDeseos, Integer> implements IListaDeseoService {

    @Autowired
    private IListaDeseoRepo repo;

    @Autowired
    private IListaDeseoMapper repoMapper;

    @Override
    protected JpaRepository<ListaDeseos, Integer> getRepo() {
        return repo;
    }

    @Override
    public List<ListadeseoFilter> listarListadeseos(int id_lista_deseo){
        return repoMapper.listarListadeseos(id_lista_deseo);
    }

}
