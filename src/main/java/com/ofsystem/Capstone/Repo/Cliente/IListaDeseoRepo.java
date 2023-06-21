package com.ofsystem.Capstone.Repo.Cliente;

import com.ofsystem.Capstone.Model.Cliente.ListaDeseos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IListaDeseoRepo extends JpaRepository<ListaDeseos, Integer> {
    ListaDeseos findByIdComp_Iuc(String iuc);

    ListaDeseos findByIdComp_IdComp (String idComp);

}
