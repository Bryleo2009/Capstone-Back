package com.ofsystem.Capstone.Service.Imple.Cliente;

import com.ofsystem.Capstone.Mapper.Filter.SeguimientoPedidoFilter;
import com.ofsystem.Capstone.Mapper.Filter.TrazabilidadPedidoFilter;
import com.ofsystem.Capstone.Mapper.IPedidoMapper;
import com.ofsystem.Capstone.Model.Cliente.Pedido;
import com.ofsystem.Capstone.Repo.Cliente.IPedidoRepo;
import com.ofsystem.Capstone.Service.Imple.CRUDServiceImpl;
import com.ofsystem.Capstone.Service.Service.Cliente.IPedidoService;
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
