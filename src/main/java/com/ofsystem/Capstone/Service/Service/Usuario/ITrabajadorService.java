package com.ofsystem.Capstone.Service.Service.Usuario;

import com.ofsystem.Capstone.Model.Usuario.Trabajador;
import com.ofsystem.Capstone.Service.Service.ICRUDService;

public interface ITrabajadorService extends ICRUDService<Trabajador, Integer> {
    Trabajador findByIdUserCliente_Username (String username);
}
