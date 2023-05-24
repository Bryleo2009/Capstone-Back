package com.ofsystem.Repo;

import com.ofsystem.Model.TrazabilidadPedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITrazabilidadPedidosRepo extends JpaRepository<TrazabilidadPedidos, Integer> {

}
