package com.ofsystem.Capstone.Repo.Cliente;

import com.ofsystem.Capstone.Model.Cliente.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPedidoRepo extends JpaRepository<Pedido, Integer> {

    Pedido findByIdComp_Iuc(String iuc);

    Pedido findByIdComp_IdComp (String idComp);
}
