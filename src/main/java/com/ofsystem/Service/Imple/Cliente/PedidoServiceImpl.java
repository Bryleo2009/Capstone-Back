package com.ofsystem.Service.Imple;

import com.ofsystem.Model.Pedido;
import com.ofsystem.Repo.IPedidoRepo;
import com.ofsystem.Service.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl extends CRUDServiceImpl<Pedido, Integer> implements IPedidoService {

    @Autowired
    private IPedidoRepo repo;

    @Override
    protected JpaRepository<Pedido, Integer> getRepo() {
        return repo;
    }

}
