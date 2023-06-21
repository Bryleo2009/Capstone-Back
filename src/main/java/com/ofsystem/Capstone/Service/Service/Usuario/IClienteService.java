package com.ofsystem.Capstone.Service.Service.Usuario;

import com.ofsystem.Capstone.Model.Usuario.Cliente;
import com.ofsystem.Capstone.Service.Service.ICRUDService;

public interface IClienteService extends ICRUDService<Cliente, Integer> {

    Cliente findByNumDocumento(String numDoc);
    Cliente findByIdUserCliente_Username(String nombre);
    boolean existsByCorreo(String correo);
    Cliente findByCorreo (String correo);

}
