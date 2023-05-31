package com.ofsystem.Service.Imple.Cliente;

import com.ofsystem.Mapper.Filter.SeguimientoListadeseosFilter;
import com.ofsystem.Mapper.Filter.SeguimientoPedidoFilter;
import com.ofsystem.Mapper.IListadeseoMapper;
import com.ofsystem.Mapper.IPedidoMapper;
import com.ofsystem.Model.Cliente.ListaDeseos;
import com.ofsystem.Model.Cliente.Pedido;
import com.ofsystem.Repo.Cliente.IListaDeseoRepo;
import com.ofsystem.Repo.Cliente.IPedidoRepo;
import com.ofsystem.Service.Service.Cliente.IListaDeseoService;
import com.ofsystem.Service.Imple.CRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListaDeseoServiceImpl extends CRUDServiceImpl<ListaDeseos, Integer> implements IListaDeseoService {

    @Autowired
    private IListaDeseoRepo repo;

    @Autowired
    private IListadeseoMapper repoMapper;
    @Override
    protected JpaRepository<ListaDeseos, Integer> getRepo() {
        return repo;
    }


    @Override
    public ListaDeseos findByIdComp_Iuc(String iuc) {
        return repo.findByIdComp_Iuc(iuc);
    }

    @Override
    public ListaDeseos findByIdComp_IdComp(String idComp) {
        return repo.findByIdComp_IdComp(idComp);
    }

    @Override
    public List<SeguimientoListadeseosFilter> listarListadeseo(int idUser) {
        return repoMapper.listarListaDeseo(idUser);
    }
}
