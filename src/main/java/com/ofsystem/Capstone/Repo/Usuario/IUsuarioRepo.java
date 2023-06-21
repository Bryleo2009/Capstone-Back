package com.ofsystem.Capstone.Repo.Usuario;

import com.ofsystem.Capstone.Model.Usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepo extends JpaRepository<Usuario, Integer> {
    Usuario findByUsername(String username);
    boolean existsByUsername (String username);
}
