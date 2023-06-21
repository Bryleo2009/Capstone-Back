package com.ofsystem.Capstone.Repo.Comprobante;

import com.ofsystem.Capstone.Model.Comprobante.TrazabilidadComprobantes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITrazabilidadComprobantesRepo extends JpaRepository<TrazabilidadComprobantes, Integer> {




}
