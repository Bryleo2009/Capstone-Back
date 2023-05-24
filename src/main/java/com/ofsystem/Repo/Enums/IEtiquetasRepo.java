package com.ofsystem.Repo;

import com.ofsystem.Model.Enums.Name.EtiquetaName;
import com.ofsystem.Model.Enums.Etiquetas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEtiquetasRepo extends JpaRepository<Etiquetas, Integer> {
    boolean existsByIdentItem(EtiquetaName ident);
    Etiquetas findByIdentItem(EtiquetaName name);
}
