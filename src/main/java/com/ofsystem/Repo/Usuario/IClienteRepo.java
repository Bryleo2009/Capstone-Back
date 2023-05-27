package com.ofsystem.Repo.Usuario;

import com.ofsystem.Model.Usuario.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepo extends JpaRepository<Cliente, Integer> {

    Cliente findByNumDocumento(String numDoc);


    Cliente findByIdUserCliente_Username(String nombre);

}
