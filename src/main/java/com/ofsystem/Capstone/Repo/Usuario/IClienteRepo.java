package com.ofsystem.Capstone.Repo.Usuario;

import com.ofsystem.Capstone.Model.Usuario.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepo extends JpaRepository<Cliente, Integer> {

    Cliente findByNumDocumento(String numDoc);
    Cliente findByIdUserCliente_Username(String nombre);
    boolean existsByCorreo(String correo);
    Cliente findByCorreo (String correo);

}
