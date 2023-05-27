package com.ofsystem.Repo.Enums;

import com.ofsystem.Model.Enums.Name.EstPedidoName;
import com.ofsystem.Model.Enums.EstPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstPedidoRepo extends JpaRepository<EstPedido, Integer> {
    boolean existsByIdentItem(EstPedidoName nombreCateg);
    EstPedido findByIdentItem(EstPedidoName name);
}
