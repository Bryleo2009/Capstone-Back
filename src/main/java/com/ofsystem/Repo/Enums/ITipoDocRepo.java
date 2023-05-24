package com.ofsystem.Repo;

import com.ofsystem.Model.Enums.Name.TipoDocName;
import com.ofsystem.Model.Enums.TipoDoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoDocRepo extends JpaRepository<TipoDoc, Integer> {
    boolean existsByIdentItem(TipoDocName tipoProductoName);
    TipoDoc findByIdentItem(TipoDocName name);
}
