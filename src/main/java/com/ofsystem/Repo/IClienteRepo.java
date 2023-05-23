package com.ofsystem.Repo;

import com.ofsystem.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepo extends JpaRepository<Cliente, Integer> {

    Cliente findByNumDocumento(String numDoc);

}
