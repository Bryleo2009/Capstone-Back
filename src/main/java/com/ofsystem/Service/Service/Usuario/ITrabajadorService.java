package com.ofsystem.Service.Service.Usuario;

import com.ofsystem.Model.Usuario.Trabajador;
import com.ofsystem.Service.Service.ICRUDService;

public interface ITrabajadorService extends ICRUDService<Trabajador, Integer> {
    Trabajador findByIdUserCliente_Username (String username);
}
