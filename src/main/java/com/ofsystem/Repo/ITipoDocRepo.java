package com.ofsystem.Repo;

import com.ofsystem.Enums.TipoDocName;
import com.ofsystem.Enums.TipoProductoName;
import com.ofsystem.Model.TipoDoc;
import com.ofsystem.Model.TipoProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoDocRepo extends JpaRepository<TipoDoc, Integer> {
    boolean existsByIdentItem(TipoDocName tipoProductoName);
    TipoDoc findByIdentItem(TipoDocName name);
}
