package com.ofsystem.Capstone.Repo.Enums;

import com.ofsystem.Capstone.Model.Enums.Name.TipoDocName;
import com.ofsystem.Capstone.Model.Enums.TipoDoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoDocRepo extends JpaRepository<TipoDoc, Integer> {
    boolean existsByIdentItem(TipoDocName tipoProductoName);
    TipoDoc findByIdentItem(TipoDocName name);
}
