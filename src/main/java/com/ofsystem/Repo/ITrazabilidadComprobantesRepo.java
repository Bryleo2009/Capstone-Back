package com.ofsystem.Repo;

import com.ofsystem.Model.TrazabilidadComprobantes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITrazabilidadComprobantesRepo extends JpaRepository<TrazabilidadComprobantes, Integer> {




}
