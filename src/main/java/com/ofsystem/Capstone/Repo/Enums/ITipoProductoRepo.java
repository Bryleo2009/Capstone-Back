package com.ofsystem.Capstone.Repo.Enums;

import com.ofsystem.Capstone.Model.Enums.Name.TipoProductoName;
import com.ofsystem.Capstone.Model.Enums.TipoProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoProductoRepo extends JpaRepository<TipoProducto, Integer> {
    boolean existsByIdentItem(TipoProductoName tipoProductoName);
    TipoProducto findByIdentItem(TipoProductoName name);
}
