package com.ofsystem.Repo;

import com.ofsystem.Model.TipoPago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoPagoRepo extends JpaRepository<TipoPago, Integer> {

}
