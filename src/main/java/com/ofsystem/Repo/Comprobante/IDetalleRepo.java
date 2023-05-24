package com.ofsystem.Repo;

import com.ofsystem.Model.Detalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDetalleRepo extends JpaRepository<Detalle, Integer> {

}
