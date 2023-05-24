package com.ofsystem.Repo.Comprobante;

import com.ofsystem.Model.Comprobante.Detalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IDetalleRepo extends JpaRepository<Detalle, Integer> {

    @Query(value = "SELECT id_dcomp FROM public.detalle_comprobante order by id_dcomp desc limit 1;", nativeQuery = true)
    int idDetalle();
}
