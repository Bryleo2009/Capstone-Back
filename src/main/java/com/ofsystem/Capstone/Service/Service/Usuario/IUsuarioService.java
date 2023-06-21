package com.ofsystem.Capstone.Service.Service.Usuario;

import com.ofsystem.Capstone.Model.Usuario.Usuario;
import com.ofsystem.Capstone.Service.Service.ICRUDService;

public interface IUsuarioService extends ICRUDService<Usuario, Integer> {
    Usuario findByUsername(String username);
    boolean existsByUsername (String username);
}
