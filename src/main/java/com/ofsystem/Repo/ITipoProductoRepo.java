package com.ofsystem.Repo;

import com.ofsystem.Enums.CategoriaName;
import com.ofsystem.Enums.TipoProductoName;
import com.ofsystem.Model.Categoria;
import com.ofsystem.Model.TipoProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoProductoRepo extends JpaRepository<TipoProducto, Integer> {
    boolean existsByIdentItem(TipoProductoName tipoProductoName);
    TipoProducto findByIdentItem(TipoProductoName name);
}
