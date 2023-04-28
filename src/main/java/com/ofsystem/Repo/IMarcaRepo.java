package com.ofsystem.Repo;

import com.ofsystem.Enums.EtiquetaName;
import com.ofsystem.Enums.MarcaName;
import com.ofsystem.Model.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMarcaRepo extends JpaRepository<Marca, Integer> {
    boolean existsByIdentItem(MarcaName ident);
    Marca findByIdentItem(MarcaName name);
}
