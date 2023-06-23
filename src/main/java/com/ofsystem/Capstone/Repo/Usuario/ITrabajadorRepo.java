package com.ofsystem.Capstone.Repo.Usuario;

import com.ofsystem.Capstone.Model.Usuario.Trabajador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITrabajadorRepo extends JpaRepository<Trabajador, Integer> {
    Trabajador findByIdUserTrabajador_Username (String username);
}
