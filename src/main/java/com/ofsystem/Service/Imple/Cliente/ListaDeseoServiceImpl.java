package com.ofsystem.Service.Imple.Cliente;

import com.ofsystem.Model.Cliente.ListaDeseos;
import com.ofsystem.Repo.Cliente.IListaDeseoRepo;
import com.ofsystem.Service.Service.Cliente.IListaDeseoService;
import com.ofsystem.Service.Imple.CRUDServiceImpl;
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
