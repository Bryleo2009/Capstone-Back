package com.ofsystem.Repo;

import com.ofsystem.Model.Enums.Name.MarcaName;
import com.ofsystem.Model.Enums.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMarcaRepo extends JpaRepository<Marca, Integer> {
    boolean existsByIdentItem(MarcaName ident);
    Marca findByIdentItem(MarcaName name);
}
