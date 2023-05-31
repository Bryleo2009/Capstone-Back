package com.ofsystem.Repo.Cliente;

import com.ofsystem.Model.Cliente.ListaDeseos;
import com.ofsystem.Model.Cliente.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IListaDeseoRepo extends JpaRepository<ListaDeseos, Integer> {
    ListaDeseos findByIdComp_Iuc(String iuc);

    ListaDeseos findByIdComp_IdComp (String idComp);

}
