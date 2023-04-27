package com.ofsystem.Repo;

import com.ofsystem.Enums.CategoriaName;
import com.ofsystem.Enums.EtiquetaName;
import com.ofsystem.Model.Categoria;
import com.ofsystem.Model.Etiquetas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEtiquetasRepo extends JpaRepository<Etiquetas, Integer> {
    boolean existsByIdentItem(EtiquetaName ident);
    Etiquetas findByIdentItem(EtiquetaName name);
}
