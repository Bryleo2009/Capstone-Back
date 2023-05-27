package com.ofsystem.Repo.Cliente;

import com.ofsystem.Model.Cliente.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPedidoRepo extends JpaRepository<Pedido, Integer> {

    Pedido findByIdComp_Iuc(String iuc);

    Pedido findByIdComp_IdComp (String idComp);
}
