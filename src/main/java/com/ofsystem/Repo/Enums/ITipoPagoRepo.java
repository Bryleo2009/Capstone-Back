package com.ofsystem.Repo;

import com.ofsystem.Model.Enums.Name.TipoPagoName;
import com.ofsystem.Model.Enums.TipoPago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoPagoRepo extends JpaRepository<TipoPago, Integer> {

    boolean existsByIdentItem(TipoPagoName nombreCateg);
    TipoPago findByIdentItem(TipoPagoName name);

}
