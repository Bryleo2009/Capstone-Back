package com.ofsystem.Service;

import com.ofsystem.Model.Cliente;

public interface IClienteService extends ICRUDService<Cliente, Integer>{

    Cliente findByNumDocumento(String numDoc);

    Cliente findByIdUserCliente_Username(String nombre);
}
