package com.ofsystem.Repo;

import com.ofsystem.Model.Trabajador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITrabajadorRepo extends JpaRepository<Trabajador, Integer> {

}
