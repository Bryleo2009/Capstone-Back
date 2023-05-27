package com.ofsystem.Service.Service.Usuario;

import com.ofsystem.Model.Usuario.Usuario;
import com.ofsystem.Service.Service.ICRUDService;

public interface IUsuarioService extends ICRUDService<Usuario, Integer> {
    Usuario findByUsername(String username);
    boolean existsByUsername (String username);
}
