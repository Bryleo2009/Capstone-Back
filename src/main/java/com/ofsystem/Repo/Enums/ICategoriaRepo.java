package com.ofsystem.Repo.Enums;

import com.ofsystem.Model.Enums.Name.CategoriaName;
import com.ofsystem.Model.Enums.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoriaRepo extends JpaRepository<Categoria, Integer> {
    boolean existsByIdentItem(CategoriaName nombreCateg);
    Categoria findByIdentItem(CategoriaName name);
}
