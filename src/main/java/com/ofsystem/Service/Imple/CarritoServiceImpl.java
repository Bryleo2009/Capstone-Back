package com.ofsystem.Service.Imple;

import com.ofsystem.Model.Carrito;
import com.ofsystem.Repo.ICarritoRepo;
import com.ofsystem.Service.ICarritoService;
import com.ofsystem.Service.ITipoComproService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CarritoServiceImpl extends CRUDServiceImpl<Carrito, Integer> implements ICarritoService {

    @Autowired
    private ICarritoRepo repo;

    @Override
    protected JpaRepository<Carrito, Integer> getRepo() {
        return repo;
    }

}
