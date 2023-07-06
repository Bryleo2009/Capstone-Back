package com.ofsystem.Repo.Usuario;

import com.ofsystem.Model.Usuario.Trabajador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITrabajadorRepo extends JpaRepository<Trabajador, Integer> {
    Trabajador findByIdUserTrabajador_Username (String username);
}
