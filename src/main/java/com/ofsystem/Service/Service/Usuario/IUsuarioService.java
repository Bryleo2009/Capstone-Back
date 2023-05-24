package com.ofsystem.Service.Service;

import com.ofsystem.Model.Usuario.Usuario;

public interface IUsuarioService extends ICRUDService<Usuario, Integer>{
    Usuario findByUsername(String username);
    boolean existsByUsername (String username);
}
