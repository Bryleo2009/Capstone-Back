package com.ofsystem.Capstone.Service.Imple.Cliente;

import com.ofsystem.Capstone.Mapper.Filter.SeguimientoListadeseosFilter;
import com.ofsystem.Capstone.Mapper.IListadeseoMapper;
import com.ofsystem.Capstone.Model.Cliente.ListaDeseos;
import com.ofsystem.Capstone.Repo.Cliente.IListaDeseoRepo;
import com.ofsystem.Capstone.Service.Imple.CRUDServiceImpl;
import com.ofsystem.Capstone.Service.Service.Cliente.IListaDeseoService;
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
