package com.ofsystem.Service.Imple.Cliente;

import com.ofsystem.Mapper.Filter.SeguimientoPedidoFilter;
import com.ofsystem.Mapper.Filter.TrazabilidadPedidoFilter;
import com.ofsystem.Mapper.IPedidoMapper;
import com.ofsystem.Model.Cliente.Pedido;
import com.ofsystem.Repo.Cliente.IPedidoRepo;
import com.ofsystem.Service.Service.Cliente.IPedidoService;
import com.ofsystem.Service.Imple.CRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServiceImpl extends CRUDServiceImpl<Pedido, Integer> implements IPedidoService {

    @Autowired
    private IPedidoRepo repo;

    @Autowired
    private IPedidoMapper repoMapper;

    @Override
    protected JpaRepository<Pedido, Integer> getRepo() {
        return repo;
    }

    @Override
    public Pedido findByIdComp_Iuc(String iuc) {
        return repo.findByIdComp_Iuc(iuc);
    }

    @Override
    public Pedido findByIdComp_IdComp(String idComp) {
        return repo.findByIdComp_IdComp(idComp);
    }

    @Override
    public List<SeguimientoPedidoFilter> listarPedido(int idUser) {
        return repoMapper.listarPedido(idUser);
    }

    @Override
    public List<TrazabilidadPedidoFilter> TrazaPedido(int idPedido) {
        return repoMapper.TrazaPedido(idPedido);
    }


}
