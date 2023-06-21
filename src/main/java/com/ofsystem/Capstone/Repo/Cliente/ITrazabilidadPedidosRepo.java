package com.ofsystem.Capstone.Repo.Cliente;

import com.ofsystem.Capstone.Model.Cliente.TrazabilidadPedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITrazabilidadPedidosRepo extends JpaRepository<TrazabilidadPedidos, Integer> {

}
