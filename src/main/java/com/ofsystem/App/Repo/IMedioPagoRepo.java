package com.ofsystem.App.Repo;

import com.ofsystem.App.Model.MedioPago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMedioPagoRepo extends JpaRepository<MedioPago, Integer> {

}
