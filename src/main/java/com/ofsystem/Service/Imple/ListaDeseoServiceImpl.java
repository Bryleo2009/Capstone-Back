package com.ofsystem.Service.Imple;

import com.ofsystem.Model.Carrito;
import com.ofsystem.Model.ListaDeseos;
import com.ofsystem.Repo.ICarritoRepo;
import com.ofsystem.Repo.IListaDeseoRepo;
import com.ofsystem.Service.ICarritoService;
import com.ofsystem.Service.IListaDeseoService;
import com.ofsystem.Service.ITipoComproService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ListaDeseoServiceImpl extends CRUDServiceImpl<ListaDeseos, Integer> implements IListaDeseoService {

    @Autowired
    private IListaDeseoRepo repo;

    @Override
    protected JpaRepository<ListaDeseos, Integer> getRepo() {
        return repo;
    }

}
