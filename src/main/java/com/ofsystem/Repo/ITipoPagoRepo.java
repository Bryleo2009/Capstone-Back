package com.ofsystem.Repo;

import com.ofsystem.Enums.EstComproName;
import com.ofsystem.Enums.TipoPagoName;
import com.ofsystem.Model.EstCompro;
import com.ofsystem.Model.TipoCompro;
import com.ofsystem.Model.TipoPago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoPagoRepo extends JpaRepository<TipoPago, Integer> {

    boolean existsByIdentItem(TipoPagoName nombreCateg);
    TipoPago findByIdentItem(TipoPagoName name);

}
