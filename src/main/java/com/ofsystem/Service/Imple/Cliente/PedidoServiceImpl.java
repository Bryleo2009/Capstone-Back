package com.ofsystem.Service.Imple.Cliente;

import com.ofsystem.Model.Cliente.Pedido;
import com.ofsystem.Repo.Cliente.IPedidoRepo;
import com.ofsystem.Service.Service.Cliente.IPedidoService;
import com.ofsystem.Service.Imple.CRUDServiceImpl;
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

    @Override
    public Pedido findByIdComp_IdComp(String idComp) {
        return repo.findByIdComp_IdComp(idComp);
    }
}
