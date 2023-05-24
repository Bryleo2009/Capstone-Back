package com.ofsystem.Service.Imple.Cliente;

import com.ofsystem.Model.Cliente.PaqueteProductos;
import com.ofsystem.Model.Usuario.Cliente;
import com.ofsystem.Repo.Cliente.IPaqueteProductosRepo;
import com.ofsystem.Service.Imple.CRUDServiceImpl;
import com.ofsystem.Service.Service.Cliente.IPaqueteProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PaqueteProductosServiceImpl extends CRUDServiceImpl<PaqueteProductos, Integer> implements IPaqueteProductosService {

    @Autowired
    private IPaqueteProductosRepo repo;

    @Override
    protected JpaRepository<PaqueteProductos, Integer> getRepo() {
        return repo;
    }

    @Override
    public List<PaqueteProductos> findByIdClienteaAndAndFechaPedidoProduc(Cliente unCliente, Date unaFecha) {
        return repo.findByIdClienteAndAndFechaPedidoProduc(unCliente,unaFecha);
    }

    @Override
    public int idPedido() {
        return repo.idPedido();
    }
}
