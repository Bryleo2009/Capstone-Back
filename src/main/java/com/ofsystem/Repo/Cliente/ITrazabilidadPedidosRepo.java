package com.ofsystem.Repo.Cliente;

import com.ofsystem.Model.Cliente.TrazabilidadPedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITrazabilidadPedidosRepo extends JpaRepository<TrazabilidadPedidos, Integer> {

}
