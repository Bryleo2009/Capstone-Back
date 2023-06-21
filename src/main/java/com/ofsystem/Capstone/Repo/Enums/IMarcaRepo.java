package com.ofsystem.Capstone.Repo.Enums;

import com.ofsystem.Capstone.Model.Enums.Name.MarcaName;
import com.ofsystem.Capstone.Model.Enums.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMarcaRepo extends JpaRepository<Marca, Integer> {
    boolean existsByIdentItem(MarcaName ident);
    Marca findByIdentItem(MarcaName name);
}
