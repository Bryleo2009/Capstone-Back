package com.ofsystem.App.Repo;

import com.ofsystem.App.Model.TipoComprobante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoComprobanteRepo extends JpaRepository<TipoComprobante, Integer> {
}
