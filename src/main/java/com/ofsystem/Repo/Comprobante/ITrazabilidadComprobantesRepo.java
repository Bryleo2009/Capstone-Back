package com.ofsystem.Repo.Comprobante;

import com.ofsystem.Model.Comprobante.TrazabilidadComprobantes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITrazabilidadComprobantesRepo extends JpaRepository<TrazabilidadComprobantes, Integer> {




}
