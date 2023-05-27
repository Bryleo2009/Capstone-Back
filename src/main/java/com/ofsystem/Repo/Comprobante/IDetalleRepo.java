package com.ofsystem.Repo.Comprobante;

import com.ofsystem.Model.Comprobante.Detalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDetalleRepo extends JpaRepository<Detalle, Integer> {

    @Query(value = "SELECT id_detalle FROM public.detalle_comprobante order by id_detalle desc limit 1;", nativeQuery = true)
    int idDetalle();

    List<Detalle> findByIdComp_Iuc (String iuc);
}
