package com.ofsystem.Repo;

import com.ofsystem.Enums.EtiquetaName;
import com.ofsystem.Enums.TallaName;
import com.ofsystem.Enums.TipoProductoName;
import com.ofsystem.Model.Talla;
import com.ofsystem.Model.TipoProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITallaRepo extends JpaRepository<Talla, Integer> {
    boolean existsByNombreTalla(TallaName name);
    Talla findByNombreTalla(TallaName name);
}
