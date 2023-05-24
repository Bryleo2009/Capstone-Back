package com.ofsystem.Repo;

import com.ofsystem.Model.Usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepo extends JpaRepository<Usuario, Integer> {
    Usuario findByUsername(String username);
    boolean existsByUsername (String username);
}
